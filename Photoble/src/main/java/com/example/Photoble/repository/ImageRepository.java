package com.example.Photoble.repository;

import com.example.Photoble.entity.Image;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name = "image")
public interface ImageRepository extends JpaRepository<Image, String> {
    List<Image> findByUser(String user);

    Image findByUserAndImagename(String user, String imagepath);
    Image findByImagepath(String imagepath);
    Image findByImagename(String imagename);
}
