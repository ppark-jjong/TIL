package com.example.Photoble.repository;


import com.example.Photoble.entity.Tag;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "tag")
public interface TagRepository extends JpaRepository<Tag, String> {
}
