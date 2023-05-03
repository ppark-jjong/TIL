package com.example.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
