package com.pratice.second.repository;

import com.pratice.second.entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface userRepository extends JpaRepository<userEntity, Long> {
    userEntity findByid(String id);
}
