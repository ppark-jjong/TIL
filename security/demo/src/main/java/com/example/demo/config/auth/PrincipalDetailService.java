package com.example.demo.config.auth;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//security 설정에서 loginProcessUrl("/login")로 걸어놓은 Url
// 즉 login 요청이 오면 자동으로 UserDetailService 타입으로 IoC 되어 있는 loadUserByUsername함수가 실행 되는 규칙
@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    //시큐리티 session(내부 Authentication(내부 userDetails))에 저장됨
//    즉 밑에 메서드는 로그인 메서드 서비스라고 봐야됨 (시큐리티 session(내부 Authentication(내부 UserDetails)))
    @Override
    //매개변수의 username은 login.html에서 form 태그 안에서 받는 name값과 일치 하여야 한다(username만 자동 지정되어 있음)
    //만약 다른 변수를 사용할 경우 SecurityConfig에서 설정 값 변경을 해야함
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
//          Session값에 저장될 userDetail 정보를 리턴해준다
            return new PrincipalDetails(user);
        } else {
            return null;
        }
    }
}