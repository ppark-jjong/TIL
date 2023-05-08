package com.example.bpm.entity;

import com.example.bpm.dto.ProjectDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId")
    private Long projectId;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "projectPublic")
    private Long projectPublic;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectIdInRole")
    private List<ProjectRoleEntity> projectRoleEntityList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectIdToRequest")
    private List<ProjectRequestEntity> projectRequestEntityList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectIdToHead")
    private List<HeadEntity> HeadEntityList = new ArrayList<>();

    public static ProjectEntity toProjectEntity(ProjectDto projectDto) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectId(projectDto.getProjectId());
        projectEntity.setTitle(projectDto.getTitle());
        projectEntity.setSubtitle(projectDto.getSubtitle());
        projectEntity.setProjectPublic(projectDto.getProjectPublic());
        return projectEntity;
    }

}
