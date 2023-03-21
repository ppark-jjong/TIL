package com.pratice.second.controller;

import com.pratice.second.dto.userDto;
import com.pratice.second.entity.exerciseEntity;
import com.pratice.second.entity.totalEntity;
import com.pratice.second.entity.userEntity;
import com.pratice.second.repository.exerciseRepository;
import com.pratice.second.repository.totalRepository;
import com.pratice.second.repository.userRepository;
import com.pratice.second.service.calculatorService;
import com.pratice.second.service.userService;
import com.pratice.second.user.config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Math.*;

@Slf4j
@Controller
public class MainController {
    @Autowired
    private userService userService;
    @Autowired
    private userRepository userRepository;
    @Autowired
    private exerciseRepository exerciseRepository;
    @Autowired
    private calculatorService calculatorService;
    @Autowired
    private totalRepository totalRepository;

    @GetMapping("/home")
    public String index() {
        return "home";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/search")
    public String search() { return "search"; }

    @GetMapping("/map")
    public String map() {
        return "map";
    }

    @GetMapping("/secondhome")
    public String secondhome(Model model) {
        model.addAttribute("userId", config.userName);
        return "secondhome";
    }

    @GetMapping("/mypage")
    public String mypage(Model model) {
        userEntity entity = userRepository.findByid(config.userName);
        double bmi = calculatorService.calculateBMI(entity.getId());
        String bmis = calculatorService.calculateBMIS(bmi);
        totalEntity totalEntity = totalRepository.findById(entity.getUser_id()).orElse(null);
        model.addAttribute("totalEntity", totalEntity);
        model.addAttribute("userEntity", entity);
        model.addAttribute("bmi", bmi);
        model.addAttribute("bmis", bmis);
        return "mypage";
    }

    @GetMapping("/change")
    public String change() {
        return "change";
    }

    @GetMapping("/delete")
    public String delete() {return "delete"; }

    @GetMapping("/exercise")
    public String exercise(Model model) {
        List<exerciseEntity> exerciseEntityList = exerciseRepository.findAll();
        model.addAttribute("exerciseEntityList", exerciseEntityList);
        return "exercise";}

}

