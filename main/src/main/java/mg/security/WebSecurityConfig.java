package mg.security;

import mg.BasicCORSFilter;
import mg.profile.service.BasicUserDetailsService;
import mg.security.custom.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_ALL = {
            "/resources/**",
            "/static/**",
            "/public/**",
            "/css/**",
            "/images/**",
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/api/v1/weather/**",
            "/api/v1/finance/**",
            "/api/v1/news/**",
            "/api/v1/token/**"
    };

    private static final String[] AUTH_AUTHENTICATED = {
            "/user/details",
            "/api/v1/profile/**"
    };

    private static final String[] AUTH_ADMIN = {
            "/user/list",
            "/admin/**",
            "/api/v1/api-consumer/**"
    };

    @Autowired
    private MGBasicAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private BasicAuthenticationProvider authenticationProvider;
    @Autowired
    private BasicAuthenticationSuccessHandler authSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler authFailureHandler;
    @Autowired
    private BasicCORSFilter basicCORSFilter;
    @Autowired
    private BasicUserDetailsService basicUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .addFilterBefore(basicCORSFilter, LogoutFilter.class)
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                    .antMatchers(AUTH_ALL).permitAll()
                    .antMatchers(AUTH_AUTHENTICATED).hasAnyRole("ADMIN", "USER", "AUTHOR")
                    .antMatchers(AUTH_ADMIN).hasRole("ADMIN")
                //.and().httpBasic().authenticationEntryPoint(authenticationEntryPoint)
                //.and().addFilterAfter(digestAuthenticationFilter(), BasicAuthenticationFilter.class)
                .and()
                .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DigestAuthenticationEntryPoint digestEntryPoint() {
        DigestAuthenticationEntryPoint digestAuthenticationEntryPoint = new DigestAuthenticationEntryPoint();
        digestAuthenticationEntryPoint.setKey("acegi");
        digestAuthenticationEntryPoint.setRealmName("mg_realm");
        digestAuthenticationEntryPoint.setNonceValiditySeconds(10);
        return digestAuthenticationEntryPoint;
    }

    @Bean
    public DigestAuthenticationFilter digestAuthenticationFilter() {
        DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
        digestAuthenticationFilter.setAuthenticationEntryPoint(digestEntryPoint());
        digestAuthenticationFilter.setUserDetailsService(basicUserDetailsService);
        return digestAuthenticationFilter;
    }
}
