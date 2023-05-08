package com.hoanganht1k27.springsecuritybasic.config;

import com.hoanganht1k27.springsecuritybasic.model.Cart;
import com.hoanganht1k27.springsecuritybasic.model.Customer;
import com.hoanganht1k27.springsecuritybasic.repository.CartRepo;
import com.hoanganht1k27.springsecuritybasic.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyCommandLine implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartRepo cartRepo;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
//        List<Customer> customers = customerRepository.findByEmail("linh");
//        System.out.println(customers.size());
        List<Customer> customers = customerRepository.findAll();
        System.out.println("Customers found in the database:");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }
}
