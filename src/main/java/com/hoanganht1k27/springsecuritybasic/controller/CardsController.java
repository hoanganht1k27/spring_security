package com.hoanganht1k27.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class CardsController {
    @GetMapping("/myCards")
    public String getCardsDetails() {
        return "Cards detail from the DB";
    }
}
