package com.platzi.platzimarket.web.security;

import com.platzi.platzimarket.domain.service.PlatziUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final String[] matchersPermitAll = { "/v2/api-docs/**", "/swagger.json", "/swagger-ui.html","/swagger-resources/**","/webjars/**"};

    @Autowired
    PlatziUserDetailsService platziUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(platziUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity security) throws  Exception{
        security
                .authorizeRequests()
                .antMatchers(matchersPermitAll)
                .permitAll();
    }
}
