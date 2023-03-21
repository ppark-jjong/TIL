package com.pratice.second.controller;

import com.pratice.second.entity.totalEntity;
import com.pratice.second.entity.userEntity;
import com.pratice.second.repository.userRepository;
import com.pratice.second.service.calculatorService;
import com.pratice.second.service.searchService;
import com.pratice.second.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@Slf4j
public class searchController {

    @Autowired
    userRepository userRepository;

    @Autowired
    searchService searchService;

    @Autowired
    userService userService;

    @Autowired
    calculatorService calculatorService;

    @PostMapping("/userSearch")
    public String search(@RequestParam("name") String name, Model model,
                         HttpServletResponse response) throws Exception {
        if (!userService.confirmUser(name)) {
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('해당 유저가 존재하지 않습니다.'); </script>");
            out.flush();
            return "search";
        }
        userEntity userEntity = searchService.userSearch(name);
        totalEntity totalEntity = searchService.totalSearch(userEntity.getUser_id());
        double bmi = calculatorService.calculateBMI(userEntity.getId());
        String bmis = calculatorService.calculateBMIS(bmi);
        model.addAttribute("userEntity", userEntity);
        model.addAttribute("totalEntity", totalEntity);
        model.addAttribute("bmi", bmi);
        model.addAttribute("bmis", bmis);
        return "searchResult";
    }
}
