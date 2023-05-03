package com.example.demo2.controller;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
@Builder
public class ProjectController {
    @Autowired
    private final ProjectService projectService;

}
