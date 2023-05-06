package com.hoanganht1k27.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
    @GetMapping("/notices")
    public String getNotices() {
        return "Here are the notices details from the DB";
    }
}
