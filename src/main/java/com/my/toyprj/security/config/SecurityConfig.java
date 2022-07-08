package com.my.toyprj.security.config;
import com.my.toyprj.jwt.JwtAccessDeniedHandler;
import com.my.toyprj.jwt.JwtAuthenticationEntryPoint;
import com.my.toyprj.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CorsFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;
    private final CorsFilter corsFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests()
                .antMatchers("/main").permitAll()
                .antMatchers("/login/index").permitAll()
                .anyRequest().authenticated();


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

