package com.example.bpm.controller;

import com.example.bpm.dto.LoginForm;
import com.example.bpm.dto.UserDto;
import com.example.bpm.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Slf4j
@ToString
@RequiredArgsConstructor //생성자 주입 어노테이션 @Autorized와 비슷하게 생성자로 객체를 만들지 않아도 자동 주입 가능하게 함
@SessionAttributes("userInfo")
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping("/index")
    public String index() {
        return "main/index";
    }

    @GetMapping("/user/gosave")
    public String saveForm() {
        return "user/save";
    }

    @PostMapping("/user/dosave")
    public String save(@RequestParam("email")String email,
                       @RequestParam("password")String password,
                       @RequestParam("username")String name) {
        //UUID 부여를 위해 생성자로 접근을 한번 더한다
        UserDto NewUser = new UserDto(email, password, name);
        log.info("DTO 정상 값 입력 (컨트롤러)"+ "/" + email+ "/" + password + "/" + name);
        userService.save(NewUser);
        log.info("save 정상 작동 (컨트롤러)");
        return "user/login";
    }

    @GetMapping("/user/gologin")
    public String login() {
        return "user/login";
    }

    @PostMapping("/user/dologin")
    public String dologin(@ModelAttribute LoginForm loginForm, Model model) {
        UserDto loginResult = userService.login(loginForm);
        if (loginResult != null) {
            model.addAttribute("userInfo", loginResult);
            return "user/main";
        } else {
            return "user/login";
        }
    }
//
//    @GetMapping("/user/")
//    //사용자 목록 보여주기
//    public String findAll(Model model) {
//        List<UserDto> userDtoList = userService.findAll();
//        model.addAttribute("userList", userDtoList);
//        return "user/list";
//    }
//
//    //프로필 창으로 이동
//    @GetMapping("/user/{id}")
//    public String findById(@SessionAttribute("userInfo")UserDto userDto, Model model) {
//        UserDto findUser = userService.findById(userDto);
//        model.addAttribute("userInfo", findUser);
//        return "user/detail";
//    }
//
//    //업데이트를 위한 현재 정보를 가져오기
//    @GetMapping("/user/update")
//    public String updateForm(@SessionAttribute("userInfo")UserDto userDto, Model model) {
//        UserDto findUser = userService.updateForm(userDto);
//        model.addAttribute("findUser", userDto);
//        return "user/update";
//    }
//
//    @PostMapping("/user/update")
//    public String update(@ModelAttribute UserDto userDto) {
//        userService.save(userDto);
////        return "redirect:/user/" + userDto.getUuid();
//    }
//
//    @GetMapping("/user/delete/{id}")
//    public String deleteById(@ModelAttribute UserDto userDto) {
//        userService.deleteById(userDto);
//        return "redirect:/user/";
//    }
//
//    @GetMapping("/user/logout")
//    public String logout(HttpSession session) {
//        //세션으로 로그아웃 처리
//        session.invalidate();
//        return "user/index";
//    }

}