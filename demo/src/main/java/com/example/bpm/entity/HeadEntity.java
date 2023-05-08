package com.example.bpm.entity;

import com.example.bpm.dto.HeadDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "head")
public class HeadEntity {
    @Id
    private Long headId;

    @Column
    private String title;

    @Column
    private Date startDay;

    @Column
    private Date endDay;

    @Column
    private int completion;

    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    private ProjectEntity projectIdToHead;

    public static HeadEntity toHeadEntity(HeadDto headDto) {
        HeadEntity headEntity = new HeadEntity();
        headEntity.setHeadId(headDto.getHeadId());
        headEntity.setTitle(headDto.getTitle());
        headEntity.setStartDay(headDto.getStartDay());
        headEntity.setEndDay(headDto.getEndDay());
        headEntity.setCompletion(headDto.getCompletion());
        headEntity.setProjectIdToHead(headDto.getProjectIdToHead());
        return headEntity;
    }
}
