package com.example.Photoble.repository;



import com.example.Photoble.entity.Comments;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name = "comments")
public interface CommentsRepository extends JpaRepository<Comments, Integer> {
    List<Comments> findByBoard(Integer id);
    List<Comments> findByUser(String user);
}
