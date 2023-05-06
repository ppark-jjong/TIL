package com.example.bpm.controller;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@Builder
public class MainController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
