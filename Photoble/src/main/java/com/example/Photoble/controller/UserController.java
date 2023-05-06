package com.example.Photoble.controller;

import com.example.Photoble.entity.Board;
import com.example.Photoble.entity.User;
import com.example.Photoble.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String getLogin(){

        return "user/login";
    }

    @PostMapping("/login")
    public String postLogin(User user, HttpSession session, Model model){

        if(userService.loginProcess(user)){
            model.addAttribute("title", "Failed!");
            model.addAttribute("message","로그인 실패");
            model.addAttribute("url", "/login");

            return "sub/alert";
        }

        session.removeAttribute("userName");
        session.setAttribute("userName", user.getUserid());

        return "redirect:/cloud/main";
    }

    @GetMapping("/join")
    public String getJoin(){

        return "user/join";
    }

    @PostMapping("/join")
    public String postJoin(User user, Model model){

        if(userService.joinProcess(user)){
            model.addAttribute("title", "Failed!");
            model.addAttribute("message","회원가입 실패");
            model.addAttribute("url", "/join");

            return "sub/alert";
        }
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model){
        session.invalidate();

        model.addAttribute("title", "Success!");
        model.addAttribute("message","로그아웃 성공");
        model.addAttribute("url", "/login");

        return "sub/alert";
    }

    @GetMapping("/mypage/info")
    public String mypageInfo(Model model, HttpSession session){
        if (session.getAttribute("userName") == null){
            return "redirect:/login";
        }

        model.addAttribute("user", userService.selectUser(session.getAttribute("userName").toString()));

        return "user/mypage_info";
    }

    @GetMapping("/mypage/notice")
    public String mypagenotice(HttpSession session, Model model,
                               @PageableDefault(page = 0, size = 8, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                               String searchKeyword){
        if (session.getAttribute("userName") == null){
            return "redirect:/login";
        }

        Page<Board> list = null;

        try {
            if(searchKeyword.isBlank()) {
                searchKeyword = null;
            }
        }
        catch (Exception e){

        }

        if (searchKeyword == null){
            list = userService.boardList(session.getAttribute("userName").toString(), pageable);
        }
        else {
            list = userService.boardSearchTitle(searchKeyword, pageable);
        }

        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        model.addAttribute( "list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);


        return "user/mypage_notice";
    }

    @PostMapping("/passwordChange")
    public String passwordChange(Model model, HttpSession session, String password){

        userService.changePassword(session.getAttribute("userName").toString(), password);

        model.addAttribute("title", "Success!");
        model.addAttribute("message","비밀번호 변경 성공");
        model.addAttribute("url", "/mypage/info");

        return "sub/alert";
    }

    @PostMapping("/emailChange")
    public String emailChange(Model model, HttpSession session, String email){
        userService.changeEmail(session.getAttribute("userName").toString(), email);

        model.addAttribute("title", "Success!");
        model.addAttribute("message","이메일 변경 성공");
        model.addAttribute("url", "/mypage/info");

        return "sub/alert";
    }

    @GetMapping("/exitQuestion")
    public String exitUser(Model model, HttpSession session){

        model.addAttribute("title", "Warning!");
        model.addAttribute("message","회원 탈퇴를 하시겠습니까?");
        model.addAttribute("url", "/exitUser");

        return "sub/alert";
    }

    @GetMapping("/exitUser")
    public String exitUser(HttpSession session){

        userService.UserExit(session.getAttribute("userName").toString());
        session.invalidate();

        return "redirect:/login";
    }
}
