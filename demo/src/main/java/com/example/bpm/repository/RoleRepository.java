package com.example.bpm.repository;

import com.example.bpm.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <RoleEntity, Long> {
}
