package com.example.demo.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "board")
public class Board {
    @Id
    //데이터 등록 처리 중 해당 에러 발생 (테이블 시퀀스 값이 없다는 상황)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardid;
    @Column
    private String boardTitle;
    @Column
    private String boardContent;
    @Column
    private String date;


    public void patch(Board board) {
        if(board.title != null)
            this.title = board.title;
        if(board.content != null)
            this.content = content;
    }
}