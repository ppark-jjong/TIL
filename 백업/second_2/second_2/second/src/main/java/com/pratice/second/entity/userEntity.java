package com.pratice.second.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userinfo")
@NoArgsConstructor
@AllArgsConstructor
public class userEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String age;

    @Column
    private String birth;

    @Column
    private String height;

    @Column
    private String weight;

    @Column
    private Long sex;
}
