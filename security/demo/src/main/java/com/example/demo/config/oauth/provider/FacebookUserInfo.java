package com.example.demo.config.oauth.provider;

import java.util.Map;

public class FacebookUserInfo implements OAuth2UserInfo {

    private Map<String, Object> attributes; // oAuth2User.getAttributes()

    public FacebookUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {
        //facebook(이하 meth 산하 인스타도 마찬가지) 토큰을 따올때 id 값이 저장되어 있는 key 값이름은 id 이다
        return (String) attributes.get("id");
    }

    @Override
    public String getProvider() {
        return "facebook";
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }
}