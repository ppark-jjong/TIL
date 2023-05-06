package com.example.Photoble.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    private String userid;

    private String password;

    private String email;
}
