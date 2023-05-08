package com.example.bpm.entity;

import com.example.bpm.dto.UserDto;
import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "user_info")
public class UserEntity {
    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;


    //주인으로 설정된 부분은 DB 의 연관관계와 매핑되서 외래키를 관리하고, 다른 한쪽은 읽기만 가능하게된다.
    //외래키를 관리하는쪽(외래키가 존재하는 쪽) 즉, 주인은 @JoinColumn 을 써주고, 그렇지 않은쪽은 mappedBy 를 쓰는것이다.
    //(단방향일때는 mappedBy 안써도됨)
    //@JoinColumn 어노테이션을 이용해서, 외래키가 어디에 있는지 알려준다는점이 중요하다.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sendUUID")
    private List<ProjectRequestEntity> projectRequestEntityList1 = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recvUUID")
    private List<ProjectRequestEntity> projectRequestEntityList2 = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "uuidInRole")
    private List<ProjectRoleEntity> projectRoleEntityList = new ArrayList<>();
    //Entity -> DTO 변환 메서드

    public static UserEntity toUserEntity(UserDto userDto) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUuid(String.valueOf(userDto.getUuid()));
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEmail((userDto.getEmail()));
        return userEntity;

    }

    //새로운 정보의 DTO를 받아 Entity를 최신화 (update) 시키는 메서드
    public static UserEntity toUpdateuserEntity(String email, String password, String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        userEntity.setName(name);
        return userEntity;
    }
}
