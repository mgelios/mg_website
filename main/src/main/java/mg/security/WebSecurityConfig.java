package mg.security;

import mg.BasicCORSFilter;
import mg.profile.service.BasicUserDetailsService;
import mg.security.custom.AuthenticationFailureHandler;
import mg.security.custom.BasicAuthenticationSuccessHandler;
import mg.security.custom.BasicAuthenticationProvider;
import mg.security.custom.MGBasicAuthenticationEntryPoint;
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
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_ALL = {
            "/resources/**",
            "/api/v1/**",
            "/static/**",
            "/public/**",
            "/css/**",
            "/images/**",
            "/service/calc",
            "/user/login",
            "/user/registration",
            "/weather/current",
            "/currency/values",
            "/swagger-resources/**",
            "/swagger-ui.html"
    };

    private static final String[] AUTH_AUTHENTICATED = {
            "/user/details"
    };

    private static final String[] AUTH_ADMIN = {
            "/user/list",
            "/admin/**"
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
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(basicCORSFilter, LogoutFilter.class)
                .authorizeRequests()
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                    .antMatchers(AUTH_ALL).permitAll()
                    .antMatchers(AUTH_AUTHENTICATED).authenticated()
                    .antMatchers(AUTH_ADMIN).hasRole("ADMIN")
                .and().httpBasic().authenticationEntryPoint(authenticationEntryPoint)
                .and().csrf().disable();
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
