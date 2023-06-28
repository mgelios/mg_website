package mg;

import mg.security.token.JWTAuthorizationFilter;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextHolderFilter;

@Configuration
@EnableAsync
@EnableScheduling
@EnableWebSecurity
public class AppConfig {

    private static final String[] AUTH_ALL = {
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/api/v1/weather/**",
            "/api/v1/finance/**",
            "/api/v1/news/**",
            "/api/v1/token/**",
            "/api/v1/guest/profile/**"
    };

    private static final String[] AUTH_AUTHENTICATED = {
            "/api/v1/authorized/profile/**"
    };

    private static final String[] AUTH_ADMIN = {
            "/api/v1/admin/api-consumer/**",
            "/api/v1/admin/profile/**"
    };

//    @Autowired
//    private BasicAuthenticationProvider authenticationProvider;
//    @Autowired
//    private BasicUserDetailsService basicUserDetailsService;

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider);
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                    .requestMatchers(AUTH_ALL).permitAll()
                    .requestMatchers(AUTH_AUTHENTICATED).hasAnyRole("ADMIN", "USER", "AUTHOR")
                    .requestMatchers(AUTH_ADMIN).hasRole("ADMIN")
                )
                .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
