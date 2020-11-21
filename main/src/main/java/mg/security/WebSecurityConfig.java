package mg.security;

import lombok.AllArgsConstructor;
import mg.BasicCORSFilter;
import mg.security.custom.MGAuthenticationFailureHandler;
import mg.security.custom.MGAuthenticationSuccessHandler;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;

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
    private MGAuthenticationSuccessHandler authSuccessHandler;
    @Autowired
    private MGAuthenticationFailureHandler authFailureHandler;
    @Autowired
    private BasicCORSFilter basicCORSFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                addFilterBefore(basicCORSFilter, LogoutFilter.class).
                authorizeRequests()
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                    .antMatchers(AUTH_ALL).permitAll()
                    .antMatchers(AUTH_AUTHENTICATED).authenticated()
                    .antMatchers(AUTH_ADMIN).hasRole("ADMIN")
                .and().httpBasic().authenticationEntryPoint(authenticationEntryPoint)
                .and().formLogin().successHandler(authSuccessHandler).failureHandler(authFailureHandler)
                .and().logout()
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
}
