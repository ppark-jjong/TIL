package com.pratice.second.repository;

import com.pratice.second.entity.totalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface totalRepository extends JpaRepository<totalEntity, Long> {
}
