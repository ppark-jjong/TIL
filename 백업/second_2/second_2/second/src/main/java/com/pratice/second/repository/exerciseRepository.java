package com.pratice.second.repository;

import com.pratice.second.entity.exerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface exerciseRepository extends JpaRepository<exerciseEntity, Integer> {
    exerciseEntity findByname(String name);
    @Override
    ArrayList<exerciseEntity> findAll();
}