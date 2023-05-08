
package com.example.demo.dto;

import com.example.demo.entity.Board;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦 (Lombok)
@ToString
public class BoardForm {
    private Long id;
    private String title;
    private String content;

    public Board toEntity() {
        return new Board(id, title, content);
    }
}