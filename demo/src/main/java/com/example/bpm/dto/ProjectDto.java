package com.example.bpm.dto;

import com.example.bpm.entity.ProjectEntity;
import com.example.bpm.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long projectId;
    private String title;
    private String subtitle;
    private Long projectPublic;

    public static ProjectDto toProjectDto(ProjectEntity projectEntity) {
        ProjectDto projectDto = new ProjectDto(projectEntity.getProjectId(), projectEntity.getTitle(), projectEntity.getSubtitle(), projectEntity.getProjectPublic());
        return projectDto;
    }
}
