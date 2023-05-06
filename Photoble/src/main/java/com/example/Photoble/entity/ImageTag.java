package com.example.Photoble.entity;

import com.example.Photoble.entity.customEntity.ImageTagPK;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity
@Data
@IdClass(ImageTagPK.class)
public class ImageTag {

    @Id
    @Column(name = "image")
    private String image;

    @Id
    @Column(name = "tag")
    private String tag;

    public ImageTag() {}
}
