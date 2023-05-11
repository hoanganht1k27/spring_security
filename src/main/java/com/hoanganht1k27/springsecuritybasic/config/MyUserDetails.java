package com.hoanganht1k27.springsecuritybasic.config;

import com.hoanganht1k27.springsecuritybasic.model.Authority;
import com.hoanganht1k27.springsecuritybasic.model.Customer;
import com.hoanganht1k27.springsecuritybasic.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetails implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password = null;
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Customer> customers = customerRepository.findByEmail(username);
        if (customers.size() == 0) {
            throw new UsernameNotFoundException("User details not found for user: " + username);
        } else {
            userName = customers.get(0).getEmail();
            password = customers.get(0).getPwd();
            for (Authority a : customers.get(0).getAuthorities()) {
                authorities.add(new SimpleGrantedAuthority(a.getName()));
            }

        }
        return new User(username, password, authorities);
    }
}
