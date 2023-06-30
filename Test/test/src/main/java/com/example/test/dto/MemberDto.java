package com.example.test.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class MemberDto {
    String name;
    String email;
    String organization;
    @Override
    public String toString() {
        return "MemberDto{" +
                "name = " + name +
                "email = " + email +
                "organization = " + organization + "}";
    }
}
