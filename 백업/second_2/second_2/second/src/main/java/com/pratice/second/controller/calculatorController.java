package com.pratice.second.controller;

import com.pratice.second.entity.userEntity;
import com.pratice.second.repository.userRepository;
import com.pratice.second.service.calculatorService;
import com.pratice.second.user.config;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@Slf4j
@Data
public class calculatorController {

    @Autowired
    calculatorService calculatorService;
    @Autowired
    userRepository userRepository;

    @RequestMapping(value = "/calculator/calculation", method = RequestMethod.POST)
    public String calculation(@RequestParam("name") String name, @RequestParam("time") int time, Model model,
                              HttpServletResponse response) throws Exception {
        userEntity userEntity = userRepository.findByid(config.userName);   // 접속중인 유저 탐색

        if (!calculatorService.confirmExercise(name)) {              //예외 처리
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('등록되지 않은 운동입니다.'); </script>");
            out.flush();
            return "calculator";
        }

        double bmi = calculatorService.calculateBMI(userEntity.getId());
        String bmis = calculatorService.calculateBMIS(bmi);
        double bmiAverage = calculatorService.calculateBmiAverage(bmi, Integer.parseInt(userEntity.getAge()),
                userEntity.getSex());       // bmi 평균 검색

        double result = calculatorService.calculate(name, time);    // 운동 칼로리 검색
        if (result != 0) {
            model.addAttribute("result", result);
        } else return null;

        calculatorService.saveTotal(time, result);                  // totalRepository 저장

        double chicken = calculatorService.countChicken(result);
        int taxi = calculatorService.countTaxi(time);
        double movie = calculatorService.countMovie(time);
        int pay = calculatorService.pay(time);
        int music = calculatorService.music(time);


        if (userEntity.getSex() == 0) {
            model.addAttribute("sex", "남성");
        } else {
            model.addAttribute("sex", "여성");
        }

        model.addAttribute("userEntity", userEntity);
        model.addAttribute("bmi", bmi);
        model.addAttribute("bmis", bmis);
        model.addAttribute("average", bmiAverage);
        model.addAttribute("chicken", chicken);
        model.addAttribute("taxi", taxi);
        model.addAttribute("movie", movie);
        model.addAttribute("pay", pay);
        model.addAttribute("music", music);


        return "/result";
    }


}