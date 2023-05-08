package com.example.bpm.entity;

import com.example.bpm.dto.ProjectRequestDto;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "project_requst")
@IdClass(ProjectRequestPKEntity.class)
public class ProjectRequestEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "send_uuid")
    private UserEntity sendUUID;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recv_uuid")
    private UserEntity recvUUID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private ProjectEntity projectIdToRequest;


    public static ProjectRequestEntity toProjectRequestEntity(ProjectRequestDto projectRequestDto) {
        ProjectRequestEntity projectRequestEntity = new ProjectRequestEntity();
        projectRequestEntity.setSendUUID(projectRequestDto.getSendUUID());
        projectRequestEntity.setRecvUUID(projectRequestDto.getRecvUUID());
        return projectRequestEntity;
    }
}
