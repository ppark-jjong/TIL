package com.example.bpm.entity;

import com.example.bpm.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@DynamicInsert
@Table(name = "user")
//@IdClass(UserPKEntity.class)
public class UserEntity {
//    @Id
//    @Column(name = "uuid")
//    private String uuid;

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    public static UserEntity toUserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
//        userEntity.setUuid(userDto.getUuid());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setName((userDto.getName()));
        return userEntity;

    }

    //새로운 정보의 DTO를 받아 Entity를 최신화 (update) 시키는 메서드
    public static UserEntity toUpdateuserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
//        userEntity.setUuid(String.valueOf(userDto.getUuid()));
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setName(userDto.getName());
        return userEntity;
    }
}
