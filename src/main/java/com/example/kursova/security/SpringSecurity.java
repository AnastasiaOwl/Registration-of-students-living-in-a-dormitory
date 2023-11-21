package com.example.kursova.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {


    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/register/**","/index", "/login","/style.css", "/image/ajy.jpg", "/webjars/bootstrap/5.2.3/css/bootstrap.min.css").permitAll()
                                .requestMatchers("/main_page").hasAnyRole("ADMIN", "Accountant", "Employee")
                                .requestMatchers("/student").hasAnyRole("ADMIN", "Accountant", "Employee")
                                .requestMatchers("/payment").hasAnyRole("ADMIN", "Accountant", "Employee")
                                .requestMatchers("/event").hasAnyRole("ADMIN", "Accountant", "Employee")
                                .requestMatchers("/room").hasAnyRole("ADMIN", "Accountant", "Employee")
                                .requestMatchers("/chummery").hasAnyRole("ADMIN", "Accountant", "Employee")
                                .requestMatchers("/service").hasAnyRole("ADMIN", "Accountant", "Employee")


                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/main_page")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}