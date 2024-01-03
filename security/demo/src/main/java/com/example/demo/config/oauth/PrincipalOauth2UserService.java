package com.example.demo.config.oauth;

import com.example.demo.config.auth.PrincipalDetails;
import com.example.demo.config.oauth.provider.FacebookUserInfo;
import com.example.demo.config.oauth.provider.GoogleUserInfo;
import com.example.demo.config.oauth.provider.NaverUserInfo;
import com.example.demo.config.oauth.provider.OAuth2UserInfo;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

/*코드 받기 -> 액세스 토큰(권한) -> 사용자 프로필 가져오기 -> 사용자 프로필 정보를 토대로 로그인 자동진행
 * 만약 추가로 정보가 필요하다면 기입 로직 처리*/
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    //해당 함수 종료 시 @AuthenticationPrincipal 어노테이션이 만들어진다.
    //oauth 토큰 인증을 후처리 해주는 함수 (구글 로그인으로부터 받은 userRequest라는 데이터에 대한 후처리 함수 즉 구글 토큰 + 사용자 정보)
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("userRequest: " + userRequest.getAccessToken().getTokenValue()); //토큰 정보
        //요청 받은 user 정보를 새로운 객체에 삽입
        OAuth2User oAuth2User = super.loadUser(userRequest);
        //사용자 프로필 모든 정보(여기서 얻어내는 값을 회원가입 정보와 일치시키면 편함)
        /*구글 로그인 버튼 클릭 -> 구글 로그인창 -> 로그인 완료 -> code를 리턴(OAuth-Client 라이브러리) -> 근데 구글은 AccessToken과 사용자 프로필을 보통 리턴
        리턴된 userRequest 정보 -> loadUser함수 호출 -> 구글로 부터 회원 프로필을 얻음*/
        System.out.println("getAuthorities: " + oAuth2User.getAuthorities());

        OAuth2UserInfo oAuth2UserInfo = null;

        //회원가입을 강제로 진행
        if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            System.out.println("구글 로그인 요청");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("facebook")) {
            System.out.println("페이스북 로그인 요청");
            oAuth2UserInfo = new FacebookUserInfo(oAuth2User.getAttributes());
        //네이버는 response라는 Map 리스트 값에 묶여서 토큰이 추출됨
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
            System.out.println("네이버 로그인 요청");
            oAuth2UserInfo = new NaverUserInfo((Map) oAuth2User.getAttributes().get("response"));
        } else {
            System.out.println("구글 페이스북 네이버만 허용함");
        }

        String provider = oAuth2UserInfo.getProvider();
        String providerId = oAuth2UserInfo.getProviderId();
        String username = provider + "_" + providerId; //google_구글아이디값
        String password = bCryptPasswordEncoder.encode("겟인데어");
        String email = oAuth2UserInfo.getEmail();
        String role = "ROLE_USER";



        User userEntity = userRepository.findByUsername(oAuth2UserInfo.getName());
        if (userEntity == null) {
            System.out.println("OAuth 로그인 최초입니다.");
            userEntity = User.builder()
                    .username(oAuth2UserInfo.getName())
                    .password(password)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userRepository.save(userEntity);
        }else {
            System.out.println("구글 로그인을 이미 한적이 있어 가입된 회원입니다.");
        }
        //결국에는 local이던 어떤 기타 홈페이지 로그인이든 하나의 dto 타입으로 모이게 된다.
        return new PrincipalDetails(userEntity, oAuth2User.getAttributes());
    }
}