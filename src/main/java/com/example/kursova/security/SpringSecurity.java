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
                        authorize.requestMatchers("/register/**","/index", "/login","/style.css", "/image/ajy.jpg", "/webjars/bootstrap/5.2.3/css/bootstrap.min.css",
                                        "/webjars/popperjs_core/2.11.7/dist/umd/popper.js", "/webjars/jquery/3.6.4/dist/jquery.js","/webjars/bootstrap/5.2.3/js/bootstrap.min.js").permitAll()
                                .requestMatchers("/main_page","/index").hasAnyRole("ADMIN", "Employee", "Accountant")
                                .requestMatchers("/main_page","/index","/student","/event","/room","/chummery").hasAnyRole("ADMIN", "Employee")
                                .requestMatchers("/payment","/service").hasAnyRole("ADMIN", "Accountant")
                                .requestMatchers("/enterStudent","/enterRoom","/enterEvent","/enterChummery","/edit_student",
                                        "/edit_chummery","/edit_room","/edit_event","/addStudent_event","/update_student","/update_event","/update_room","/update_chummery",
                                        "/addStudent","/addEvent","/addRoom","/addChummery","/addStudentEvent","/delete_event", "/delete_room","/delete_chummery").hasRole("Employee")
                                .requestMatchers("/enterPayment","/enterService","/edit_payment","/edit_service","/payment_service","/update_payment","/update_service",
                                        "/addService","/addPayment","/addStudentPayment","/delete_service","/delete_payment").hasRole("Accountant")
                                .requestMatchers("/chummery_student","/student_chummery","/event_student","/student_event","/service_student","/student_service").hasRole("ADMIN")
                                .requestMatchers("/room_chummery","/chummery_room", "/room_student","/student_room").hasAnyRole("ADMIN", "Employee")

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