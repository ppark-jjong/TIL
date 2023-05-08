package com.example.bpm.entity;

import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public class ProjectRolePKEntity implements Serializable {
    @Column(name = "project_id")
    private Long projectIdInRole;
    @Column(name = "uuid")
    private String uuidInRole;

}
