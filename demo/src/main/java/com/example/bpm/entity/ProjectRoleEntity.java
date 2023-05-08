package com.example.bpm.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "project_role")
@IdClass(ProjectRolePKEntity.class)
public class ProjectRoleEntity {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private ProjectEntity projectIdInRole;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "uuid")
    private UserEntity uuidInRole;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role")
    private RoleEntity role;
}
