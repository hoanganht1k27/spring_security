package com.hoanganht1k27.springsecuritybasic.controller;

import com.hoanganht1k27.springsecuritybasic.model.Customer;
import com.hoanganht1k27.springsecuritybasic.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/users")
    public ResponseEntity<List<Customer>> getAllUsers() {
        return ResponseEntity.status(200).body(customerRepository.findAll());
    }
}
