package com.pratice.second.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "totalcalorie")
public class totalEntity {
    @Id
    private Long userId;

    @OneToOne(cascade = CascadeType.ALL)    // cascade. 영속성 전이. 부모 엔티티 변경시 자식 엔티티에도 영향.
    @MapsId                                 // FK를 PK로 설정
    @JoinColumn(name = "userId")
    private userEntity entity;

    @Column
    private int time;

    @Column
    private double calorie;
}
