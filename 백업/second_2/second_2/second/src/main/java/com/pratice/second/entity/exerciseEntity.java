package com.pratice.second.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "exerciseinfo")
public class exerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exerciseId;

    @Column
    private String name;

    @Column
    private double calorie;

    @Column
    private String category;
}
