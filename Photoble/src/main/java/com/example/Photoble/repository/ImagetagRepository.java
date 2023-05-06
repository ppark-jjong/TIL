package com.example.Photoble.repository;

import com.example.Photoble.entity.ImageTag;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name = "imagetag")
public interface ImagetagRepository extends JpaRepository<ImageTag, String> {
    List<ImageTag> findByImage(String image);

    List<ImageTag> findByTagContaining(String image);
    List<ImageTag> findByTag(String image);

}
