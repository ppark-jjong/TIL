package com.pratice.second.dto;

import com.pratice.second.entity.userEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userDto {
    private Long user_id;

    private String id;

    private String password;

    private String name;

    private String age;

    private String birth;

    private String height;

    private String weight;

    private Long sex;

    public userEntity toJoinEntity() {
        return new userEntity(user_id, id, password, name, age, birth, height, weight, sex);
    }
}
