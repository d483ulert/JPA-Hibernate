package com.my.toyprj.common.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity webSecurity) throws Exception{

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/**").permitAll()
            .and()
            .formLogin()
            .loginPage("/login/index")
            .successHandler(authenticationSuccessHandler())
            .usernameParameter("userId")
            .passwordParameter("passwd")
            .loginProcessingUrl("/login/ing")
            .defaultSuccessUrl("/login/ok")
            .failureUrl("/login/fail")
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login/logout")
            .invalidateHttpSession(true);

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
}

