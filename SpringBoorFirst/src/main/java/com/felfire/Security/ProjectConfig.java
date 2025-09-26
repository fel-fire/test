package com.felfire.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    private AuthenticationProvider authenticationProvider;

    public ProjectConfig(CustomerAuthenticationProvider provider) {
        authenticationProvider = provider;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        http.authenticationProvider(authenticationProvider);
        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
        return http.build();
    }

    // @Bean
    // SecurityFilterChain configureAgain(HttpSecurity http) throws Exception {
    //     http.httpBasic(Customizer.withDefaults());

    //     http.authorizeHttpRequests(c -> c.anyRequest().authenticated());

    //     UserDetails user = User.withUsername("biggay")
    //                 .authorities("read")
    //                 .password("al")
    //                 .build();

    //     UserDetailsService userDetailsService = new InMemoryUserDetailsManager(user);            
    //     http.userDetailsService(userDetailsService);  

    //     return http.build();

    // }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
