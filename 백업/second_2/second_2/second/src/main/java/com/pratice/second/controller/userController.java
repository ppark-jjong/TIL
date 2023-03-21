package com.pratice.second.controller;

import com.pratice.second.dto.userDto;
import com.pratice.second.entity.totalEntity;
import com.pratice.second.entity.userEntity;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@Slf4j
public class userController {

    @Autowired
    private userService userService;

    @Autowired
    private calculatorService calculatorService;

    @Autowired
    private userRepository userRepository;

    @Autowired
    private totalRepository totalRepository;

    @PostMapping("/join/create")
    public String createUser(userDto dto, HttpServletResponse response) throws Exception {
        if (userService.confirmUser(dto.getId())) {
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('이미 가입된 회원입니다.'); </script>");
            out.flush();
            return "redirect:/join";
        }
        userEntity created = userService.createUser(dto);
        return "redirect:/home";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String login(@RequestParam("id") String id, @RequestParam("password")String password, Model model,
                        HttpServletResponse response) throws Exception {
        if (userService.confirmLogin(id, password)) {
            config.isLogin = true;
            config.userName = id;
            config.userPassword = password;
            userEntity entity = userRepository.findByid(config.userName);
            log.info(entity.getId(), entity.getHeight(), entity.getWeight());
            model.addAttribute("userId",entity.getId());
            return "secondhome";
        } else {
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('회원 정보가 틀렸습니다.'); </script>");
            out.flush();
            return "/login";
        }
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String cal(Model model) {
        userEntity userEntity = userRepository.findByid(config.userName);
        double bmi = calculatorService.calculateBMI(config.userName);
        String bmis = calculatorService.calculateBMIS(bmi);

        totalEntity totalEntity = totalRepository.findById(userEntity.getUser_id()).orElse(null);

        model.addAttribute("bmi", bmi);
        model.addAttribute("bmis", bmis);
        model.addAttribute("userEntity", userEntity);
        model.addAttribute("totalEntity", totalEntity);
        return "calculator";
    }

    @GetMapping("/result")
    public String result() {
        return "result";
    }

    @GetMapping("/logout")
    public String logout(RedirectAttributes rttr) {
        config.isLogin = false;
        config.userName = null;
        config.userPassword = null;
        rttr.addFlashAttribute("msg", "로그아웃 완료!");
        return "redirect:/home";
    }

    @GetMapping("/change/{id}")
    public String change(@PathVariable Long id, Model model) {
        userEntity entity = userRepository.findById(id).orElse(null);
        model.addAttribute("userEntity", entity);
        return "change";
    }

    @PostMapping("/userChange")
    public String userChange(userDto dto, RedirectAttributes rttr, Model model) {
        userService.updateUser(dto);
        rttr.addFlashAttribute("msg", "수정이 완료되었습니다!");
        model.addAttribute("userId", config.userName);
        return "secondhome";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String login(@RequestParam("id") String id, @RequestParam("password")String password,
                        HttpServletResponse response) throws Exception {
        if (userService.confirmLogin(id, password)) {
            userService.deleteUser(config.userName);
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('탈퇴에 성공했습니다.'); </script>");
            out.flush();
            return "home";
        } else {
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('회원 정보가 틀렸습니다.'); </script>");
            out.flush();
            return "/delete";
        }
    }
}
