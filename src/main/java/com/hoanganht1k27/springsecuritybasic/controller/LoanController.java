package com.hoanganht1k27.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    @GetMapping("/myLoans")
    public String getLoanDetails() {
        return "Here are the loan details from the DB";
    }
}
