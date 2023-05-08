package com.example.bpm.repository;

import com.example.bpm.entity.ProjectRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRoleRepository extends JpaRepository<ProjectRoleEntity, Long> {

    @Query(value = "select * from project_role where uuid = :uuid", nativeQuery = true)
    List<ProjectRoleEntity> findByAlltoUserId(String uuid);

    @Query(value = "insert into project_requst(project_id, uuid, role)" +
            "values (?,?,?)", nativeQuery = true)
    ProjectRoleEntity insertToRoleEntity(Long projectId, String recvUUID, Long aLong);
}
