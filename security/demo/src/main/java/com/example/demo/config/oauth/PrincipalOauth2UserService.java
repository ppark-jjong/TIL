package com.example.demo.config.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

/*코드 받기 -> 액세스 토큰(권한) -> 사용자 프로필 가져오기 -> 사용자 프로필 정보를 토대로 로그인 자동진행
* 만약 추가로 정보가 필요하다면 기입 로직 처리*/
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    @Override
    //oauth 토큰 인증을 후처리 해주는 함수 (구글 로그인으로부터 받은 userRequest라는 데이터에 대한 후처리 함수 즉 구글 토큰 + 사용자 정보)
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("userRequest: " + userRequest.getAccessToken().getTokenValue()); //토큰 정보
        //사용자 프로필 모든 정보(여기서 얻어내는 값을 회원가입 정보와 일치시키면 편함)
        /*구글 로그인 버튼 클릭 -> 구글 로그인창 -> 로그인 완료 -> code를 리턴(OAuth-Client 라이브러리) -> 근데 구글은 AccessToken과 사용자 프로필을 보통 리턴
        리턴된 userRequest 정보 -> loadUser함수 호출 -> 구글로 부터 회원 프로필을 얻음*/
        System.out.println("getAuthorities: " + super.loadUser(userRequest).getAuthorities());

        OAuth2User oAuth2User = super.loadUser(userRequest);

        return super.loadUser(userRequest);
    }
}