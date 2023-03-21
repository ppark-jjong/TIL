package com.pratice.second.controller;

import com.pratice.second.dto.exerciseDto;
import com.pratice.second.entity.exerciseEntity;
import com.pratice.second.repository.exerciseRepository;
import com.pratice.second.service.exerciseService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@Slf4j
@Data
public class exerciseController {
    @Autowired
    exerciseRepository exerciseRepository;
    @Autowired
    exerciseService exerciseService;

    @RequestMapping(value = "addExercise")
    public String addExercise(exerciseDto dto, HttpServletResponse response) throws Exception {

        if (exerciseService.exerciseConfirm(dto)) {
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('이미 있는 항목입니다.'); </script>");
            out.flush();
            return "exercise";
        }
        exerciseService.addExercise(dto);
        return "redirect:/exercise";
    }
}
