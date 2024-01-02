package com.example.demo.config.auth;

import com.example.demo.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/*시큐리티가 클라이언트에서 login이라는 요청을 받고 해당 요청을 SecurityConfig Bean 파일에서 함수를 통해 낚아채어 로그인을 수행하면
 * 시큐리티가 임의의 공간인 제너릭 타입 Security ContextHolder라는 타입에다가 session 값을 저장시켜 로그인한다
 * 해당 세션에 들어갈 수 있는 값들은 정해져 있는데 => Authentication 타입의 객체만이 들어간다
 * Authentication 안에는 User 정보가 있어야 되며
 * User 타입은 UserDetails 타입의 객체 정보가 들어가야한다.
 * Security Session => Authentication => UserDetails(PrincipalDetails) 순으로 접속 가능하다
 * 그런데 Session 객체에는 무조건 Authentication 타입만 활용 가능하고 UserDetails(PrincipalDetails)는 변환되어 session에 저장되어야 한다 */
@Data
public class PrincipalDetails implements UserDetails, OAuth2User {
    private User user;
    //토큰에서 받아온 data들을 저장할 Map 리스트
    private Map<String, Object> attributes;

    //일반 로그인 생성자
    public PrincipalDetails(User user) {
        this.user = user;
    }

    //OAuth 로그인 생성자
    public PrincipalDetails(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    //해당 User의 권한을 리턴하는 메서드
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
    //여기서 부터 하단의 메서드들은 유저의 정보가 만료되어있는지
    // 휴먼계정인지 잠겨있는 지 등을 판단하고 bool 타입으로 리턴해주는 메서드 이므로 찾아보고 할것

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}