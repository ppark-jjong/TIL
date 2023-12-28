package com.example.demo.config;

import com.example.demo.config.oauth.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터체인에 등록
//securedEnabled 어노테이션 활성화하면 권한에 따라 접근을 할 수 있는 어노테이션 활용 가능 @Secured
//prePostEnabled @PreAutorize or @PostAutorize 어노테이션을 활용할 수 있으며 해당 어노테이션이 붙은 메서드가 실행 전 or 후에 config함수를 걸어줌 즉 권한을 확인하고 접속하거나 접속하고 확인함 (여러개의 권한을 걸 때 사용하기도 함)
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;
    @Bean //해당 메서드의 리턴되는 오브젝트를 IoC로 자동 등록해준다 (비밀번호 암호화를 위한 객체 생성)
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                //url에 따라 접속 할 수 있는 권한을 나누고
                .requestMatchers("/user/**").authenticated() //authenticated()는 무조건 권한이 있어야 접속할 수 있게 하는 메서드
                .requestMatchers("/manager/**").access("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')")
                .requestMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                //위의 3가지 url이 아니면 모든 권한을 허용한다
                .anyRequest().permitAll()

                //만약 권한이 없을 때는 로그인 페이지로 바로 이동하게 만드는 메서드
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login")//login주소가 호출되면 시큐리티가 자동으로 로그인을 진행해주고 따로 매핑 처리나 로직 처리 할 필요 없다
                .defaultSuccessUrl("/")

                .and()
                .oauth2Login()
                .loginPage("/loginForm")
                .userInfoEndpoint()
                .userService(principalOauth2UserService);

        return http.build();
    }
}