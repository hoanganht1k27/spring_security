package com.hoanganht1k27.springsecuritybasic.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("/myAccount")
    @PreAuthorize("hasRole('USER')")
    public String getAccountDetails() {
        return "Here are the account details from the DB";
    }

    @PostMapping("/myAccount")
    @PreAuthorize("hasRole('ADMIN')")
    public String postAccount() {
        return "This is from post route of account";
    }
}
