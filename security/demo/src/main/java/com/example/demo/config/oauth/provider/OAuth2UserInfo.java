package com.example.demo.config.oauth.provider;

// OAuth2.0 제공자들 마다 응답해주는 속성값이 달라서 공통으로 만들어준다.
public interface OAuth2UserInfo {
    String getProviderId(); //정보를 제공해주는 사이트의 ID

    String getProvider(); //정보를 제공해주는 사이트 이름

    String getEmail();

    String getName();
}