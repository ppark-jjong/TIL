package com.example.bpm.dto;

import com.example.bpm.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {
    private String uuid;
    private String email;
    private String password;
    private String name;

    //회원가입을 할 때 필요한 생성자
    public UserDto(String email, String password, String name) {
        this.uuid = UUID.randomUUID().toString();
        this.email = email;
        this.password = password;
        this.name = name;
    }



    public static UserDto toUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setUuid(userEntity.getUuid());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());
        userDto.setName(userEntity.getName());
        return userDto;
    }
}
