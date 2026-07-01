package com.spital.hospitalmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

/**
 * Configurația Spring Security.
 * Definește autentificarea JDBC și regulile de acces.
 */
@Configuration
public class SecurityConfig {//Configurează serviciul de autentificare JDBC

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    //Configurează regulile de securitate  ale apicației
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) //Dezactivează protecția CSRF pentru simplificarea testării
                .authorizeHttpRequests(auth -> auth

                        //permite accesul la consola H2 fara autentificare
                        .requestMatchers("/h2-console/**").permitAll()

                        // User și Admin pot accesa informațiile despre pacienți,medici și secții
                        .requestMatchers("/pacienti/**", "/medici/**", "/sectii/**").hasAnyRole("USER", "ADMIN")

                        //doar Admin poate gestiona diagnosticele,tratamentele și internările
                        .requestMatchers("/diagnostice/**", "/tratamente/**", "/internari/**", "/consultatii/**", "/fisemedicale/**").hasRole("ADMIN")
                        .anyRequest().authenticated()//Orice alt acces necesita autentificare
                )
                .formLogin(form -> form.permitAll()) //Activează formularul de autentificare
                .logout(logout -> logout.permitAll()); //Permite deconectarea utilizatorilor

        //Permite afișarea consolei H2 în browser
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }
}