package com.example.Photoble.repository;

import com.example.Photoble.entity.BoardImage;
import com.example.Photoble.entity.Image;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name = "board_image")
public interface BoardimageRepository extends JpaRepository<BoardImage, Integer> {
    List<BoardImage> findByBoard(Integer board);
    List<BoardImage> findByImage(String name);
}
