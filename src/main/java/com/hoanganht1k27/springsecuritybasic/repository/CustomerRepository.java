package com.hoanganht1k27.springsecuritybasic.repository;

import com.hoanganht1k27.springsecuritybasic.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmail(String email);
}
