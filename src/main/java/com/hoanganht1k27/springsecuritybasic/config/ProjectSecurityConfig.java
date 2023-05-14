package com.hoanganht1k27.springsecuritybasic.config;

import com.hoanganht1k27.springsecuritybasic.filter.AuthoritiesLoggingAfterFilter;
import com.hoanganht1k27.springsecuritybasic.filter.JwtTokenGeneratorFilter;
import com.hoanganht1k27.springsecuritybasic.filter.JwtTokenValidatorFilter;
import com.hoanganht1k27.springsecuritybasic.filter.RequestValidationBeforeFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.sql.DataSource;
import java.util.Collections;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setMaxAge(3600L);
//                        config.setAllowedHeaders(Collections.singletonList("Authorization"));
                        return config;
                    }
                })
                .and()
                .csrf().disable()
                .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers("/myAccount").hasRole("ADMIN")
                .requestMatchers("/balance/**").authenticated()
                .requestMatchers("/user").authenticated()
                        .requestMatchers("/notices", "/contact", "/register").permitAll()
                        .and().formLogin()
                        .and().httpBasic();
        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsServices() {
//        // Approach 1
////        UserDetails admin = User.withDefaultPasswordEncoder()
////                .username("admin")
////                .password("juniper@123")
////                .authorities("admin")
////                .build();
////        UserDetails user = User.withDefaultPasswordEncoder()
////                .username("user")
////                .password("juniper@123")
////                .authorities("user")
////                .build();
//        // Approach 2
//        UserDetails admin = User.withUsername("admin")
//                .password("juniper@123")
//                .authorities("admin")
//                .build();
//        UserDetails user = User.withUsername("user")
//                .password("juniper@123")
//                .authorities("user")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
