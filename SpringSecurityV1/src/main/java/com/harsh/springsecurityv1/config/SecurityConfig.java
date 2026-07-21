package com.harsh.springsecurityv1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // tell spring this the new configuration file for secuity.
@EnableWebSecurity // this actually enables the security filter etc  if we remove this springs defaults to its default settings
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http){
        http.csrf(customizer -> customizer.disable()) // disable the csrf secrity feature
            .authorizeHttpRequests(request -> request.anyRequest().authenticated())//forces each request to be authenticated first
            .formLogin(Customizer.withDefaults()) // allows form/webiste to authenticate
            .httpBasic(Customizer.withDefaults()) // allows restapi access via postman etc
            .sessionManagement(session ->  // disable creation of session
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        return http.build(); // returns the build of securityfilter chain springs reads this and then configure filtes accordingly
    }

    @Bean
    public AuthenticationProvider authenticationProvider (){
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(userDetailsService);

        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }



//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("aditya")
//                .password("aditya123")
//                .build();
//
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("harshada")
//                .password("harshada")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
}


