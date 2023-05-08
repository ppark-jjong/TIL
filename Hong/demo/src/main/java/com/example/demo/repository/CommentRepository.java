package com.example.demo.repository;

import com.example.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CommentRepository extends JpaRepository<Comment, Long> { //JpaRepository 이다
    // 특정 게시글의 모든 댓글 조회
    @Query(value = // 괄호한 value 값의 sql문을 실행시킴
            "SELECT * " +
                    "FROM comment " +
                    "WHERE article_id = :articleId",
            nativeQuery = true )//sql문이 작동하게 도와줌
    List<Comment> findByArticleId(Long articleId);
    //특정 닉네임의 모든 댓글 조회 => xml query로 작성함 orm.xml
    List<Comment> findByNickname(String nickname);
}