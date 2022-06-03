package com.my.toyprj.common.config;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter;

    @Override
    public void configure(WebSecurity webSecurity) throws Exception{

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
            httpSecurity.authorizeHttpRequests()
            .antMatchers("/user/**").authenticated()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .and()
            .formLogin()
            .loginPage("/login/index")
            .successHandler(authenticationSuccessHandler())
            .usernameParameter("userId")
            .passwordParameter("passwd")
            .loginProcessingUrl("/login/in")
            .defaultSuccessUrl("/main")
            .failureUrl("/login/fail")
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login/logout")
            .invalidateHttpSession(true)
            .disable()
            .addFilterBefore(jsonUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        httpSecurity.csrf().disable();

        httpSecurity.exceptionHandling()
            .accessDeniedPage("/disallow");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder amb)  throws Exception{
        amb.inMemoryAuthentication()
            .withUser("jsAdmin")
            .password("1q2w3e4r@@")
            .roles("ADMIN");

        amb.inMemoryAuthentication()
            .withUser("jsMember")
            .password("1q2w3e4r@@")
            .roles("MEMBER");

    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new CustomLoginSuccessHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public UserDetailsService createUserDetailsService(){
        return  new CustomUserDetailService();
    }

}

