package com.ecxfoi.wbl.wienerbergerbackend.configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(100)
public class SecurityConfig  extends WebSecurityConfigurerAdapter
{
    private static final String[] AUTH_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**"
    };

    private static final String[] ROUTES = {
            "/wienerberger",
            "/error",
            "/h2-console",
            "/h2-console/**",
            "/users/**",
            "/hello"
    };
    @EnableWebSecurity
    @Order(101)
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter
    {
        @Autowired
        private UserDetailsService myUserDetailsService;

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
        {
            auth.userDetailsService(myUserDetailsService);
        }

        @Bean
        public PasswordEncoder passwordEncoder()
        {
            return NoOpPasswordEncoder.getInstance();
        }


        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception
        {
            httpSecurity
                    .authorizeRequests().antMatchers(ROUTES).permitAll().antMatchers(AUTH_WHITELIST).permitAll()
                    .anyRequest().authenticated().and().formLogin();
            httpSecurity.csrf().ignoringAntMatchers(ROUTES);
            httpSecurity.headers().frameOptions().sameOrigin();
        }
    }
}