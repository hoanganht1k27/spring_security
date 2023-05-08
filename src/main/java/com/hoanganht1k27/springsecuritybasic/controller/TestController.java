package com.hoanganht1k27.springsecuritybasic.controller;

import com.hoanganht1k27.springsecuritybasic.model.Cart;
import com.hoanganht1k27.springsecuritybasic.model.Customer;
import com.hoanganht1k27.springsecuritybasic.repository.CartRepo;
import com.hoanganht1k27.springsecuritybasic.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/test")
    public ResponseEntity<Customer> test(@RequestParam String email) {
        Customer c = null;
//        Customer c = customerRepository.findById(id).orElse(null);
        if (email != null) {
            List<Customer> customers = customerRepository.findByEmail(email);
            if (customers.size() > 0) {
                c = customers.get(0);
            }
        }

        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping("/cart")
    public ResponseEntity<Cart> testCart(@RequestParam Long id) {
        Cart c = cartRepo.findById(id).orElse(null);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
}
