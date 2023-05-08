package com.example.demo.dto;

import com.example.demo.entity.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class CommentDto {
    private Long id;
    private String nickname;
    private String body;
    @JsonProperty("board_id") //제이슨 body 에서 받을 변수명
    private Long boardId;

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getNickname(),
                comment.getBody(),
                comment.getBoard().getId()
        );
    }
}
