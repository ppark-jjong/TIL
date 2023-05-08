package com.example.demo.entity;

import com.example.demo.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nickname;
    @Column
    private String body;

    @ManyToOne //Comment가 Many Board이 One
    @JoinColumn(name = "boardId") //하단에 생성된 객체를 참조하는 FK 컬럼명 생성
    private Board Board;

    public static Comment createComment(CommentDto dto, Board Board) {
        // 예외 처리
        if (dto.getId() != null)
            throw new IllegalArgumentException("댓글 생성 실패 ! 댓글의 id가 없어야 됩니다.");
        if (dto.getBoardId() != Board.getId())
            throw new IllegalArgumentException("게시글의 아이디가 일치 하지 않습니다.");

        // 엔티티 생성 및 반환
        return new Comment(dto.getId(),
                dto.getNickname(),
                dto.getBody(),
                Board
        );
    }

    public void patch(CommentDto dto) {
        //예외 발생
        if (this.id != dto.getId())
            throw new IllegalArgumentException("댓글 수정 실패 ! 잘못된 id 입니다.");
        // 객체 갱신
        if (dto.getNickname() != null)
            this.nickname = dto.getNickname();
        if(dto.getBody() != null)
            this.body = dto.getBody();

    }

}