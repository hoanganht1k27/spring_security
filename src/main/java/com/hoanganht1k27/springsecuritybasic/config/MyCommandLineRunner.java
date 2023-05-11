package com.hoanganht1k27.springsecuritybasic.config;


import com.hoanganht1k27.springsecuritybasic.model.Customer;
import com.hoanganht1k27.springsecuritybasic.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

//        List<Customer> customers = customerRepository.findByEmail("linh");
//        System.out.println(customers.size());
//        List<Customer> customers = customerRepository.findAll();
//        System.out.println("Customers found in the database:");
//        for (Customer customer : customers) {
//            System.out.println(customer.toString());
//        }
    }
}

