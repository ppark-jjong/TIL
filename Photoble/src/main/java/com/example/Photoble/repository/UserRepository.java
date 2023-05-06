package com.example.Photoble.repository;

import com.example.Photoble.entity.User;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name = "user")
public interface UserRepository extends JpaRepository<User, String> {
    User findByUseridAndPassword(String userid, String password);

    User findByUserid(String userid);
}
