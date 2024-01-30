package me.silvernine.tutorial.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//토큰의 정보와 Response할 때 사용함
public class TokenDto {

    private String token;
}
