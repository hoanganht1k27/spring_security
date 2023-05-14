package com.hoanganht1k27.springsecuritybasic.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/balance")
@PreAuthorize("hasRole('ADMIN')")
public class BalanceController {
    @GetMapping("/myBalance")
    public String getBalanceDetails() {
        return "Here are the balance details from the DB";
    }

    @PostMapping("/myBalance")
    public String postBalanceDetails() {
        return "Post from balance";
    }
}
