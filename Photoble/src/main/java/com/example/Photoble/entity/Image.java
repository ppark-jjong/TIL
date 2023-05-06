package com.example.Photoble.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Image {
    @Id
    private String imagename;

    private String imagepath;

    private String user;

    private String date;
}