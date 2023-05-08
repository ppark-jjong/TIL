package com.example.bpm.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequestPKEntity implements Serializable {
    private String sendUUID;
    private String recvUUID;
}
