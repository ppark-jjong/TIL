package com.example.demo.utils;

import io.jsonwebtoken.Claims;
public class JwtUtil {
//
    public static String createJwt(String userName, String secretKey) {
//  원하는 정보를 담아놓을 수 있는 Claims 라는 것이 있음
        Claims claims = Jwts.claims();

    }
}
