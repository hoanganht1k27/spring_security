package com.hoanganht1k27.springsecuritybasic.controller;

import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.server.ui.LoginPageGeneratingWebFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String sayWelcome() {
        return "Welcome";
    }
}
