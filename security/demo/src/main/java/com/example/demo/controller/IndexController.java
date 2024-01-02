package com.example.demo.controller;

import com.example.demo.config.auth.PrincipalDetails;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/test/login")
    public @ResponseBody String loginTest(Authentication authentication,
                                          //@AuthenticationPrincipal을 통해 session정보에 접근 할 수 있다
                                          @AuthenticationPrincipal UserDetails userDetails) {
        System.out.println("/test/login/============/============/============");
        //다운 캐스팅 작업 (암호화된 정보를 일반 객체로 쓸 수 있게 object 변환
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("authentication : " + authentication.getPrincipal());
        //그냥 Authentication를 불러와서 PrincipalDetails 객체 확인과 userDetails의 객체확인은 결국 같은 값을 리턴하는 걸 확인 가능
        System.out.println("userDetails " + userDetails.getUsername());
        return "세션 정보 확인";
    }

    //위의 메서드에서 그냥 login 같은 경우에는 userDetail과 principalDetails간의 큰 차이가 없었다 하지만 oauth 로그인은 다르다
    @GetMapping("/test/oauth/login")
    public @ResponseBody String loginOAuthTest(Authentication authentication,
                                               @AuthenticationPrincipal OAuth2User oAuth) {
        System.out.println("/test/oauth/login/============/============/============");
        //위 메서드와 다르게 oAuth2user 객체로 받아와야 User 정보를 확인 할 수 있다
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        System.out.println("authentication : " + authentication.getPrincipal());
        System.out.println("oAuth : " + oAuth.getAttributes()
        );
        return "세션 정보 확인";
    }

    @GetMapping({"", "/"})
    public @ResponseBody String index() {
        return "인덱스 페이지입니다.";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        System.out.println("principalDetails : " + principalDetails.getUser());
        return "user";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    @ResponseBody
    public String manager() {
        return "manager";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping("/join")
    public String join(User user) {
        System.out.print(user);
        user.setRole("ROLE_USER");
        //여기 밑에 메서드들은 시큐리티 암호화에 따라 패스워드 설정을 위한 메서드들
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        userRepository.save(user);
        return "redirect:/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    /*@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)이 활성화가 되면
     * @Secured @PreAuthorize등을 이용하여 pre post적으로 제약을 걸 수 있다*/
    @Secured("ROLE_ADMIN") //특정 메서드에 권한을 가진 사람만 접속 하게 할 수 있는 어노테이션 (하나만)
    @GetMapping("/info")
    public @ResponseBody String info() {
        return "개인정보";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
    @GetMapping("/data")
    public @ResponseBody String data() {
        return "data 정보 접근";
    }
}