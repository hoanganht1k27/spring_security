package com.hoanganht1k27.springsecuritybasic.repository;

import com.hoanganht1k27.springsecuritybasic.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
}
