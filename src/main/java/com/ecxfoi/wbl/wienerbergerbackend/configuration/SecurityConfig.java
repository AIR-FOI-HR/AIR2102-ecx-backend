package com.ecxfoi.wbl.wienerbergerbackend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    private static final String[] AUTH_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/api/login"
    };

    private static final String[] ROUTES = {
            "/wienerberger",
            "/error",
            "/h2-console",
            "/h2-console/**",
            "/users/**",
            "/api/login",
            "/api/user/"
    };

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