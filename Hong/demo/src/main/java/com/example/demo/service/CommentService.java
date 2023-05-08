package com.example.demo.service;

import com.example.demo.dto.CommentDto;
import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BoardRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
//        // 조회 : 댓글 목록
//        List<Comment> comments = commentRepository.findByArticleId(articleId);
//
//        // 변환 : 엔티티 -> DTO
//        List<CommentDto> dtos = new ArrayList<CommentDto>();
//        for (int i = 0 ; i<comments.size(); i++){
//            Comment c  = comments.get(i);
//            CommentDto d = CommentDto.createCommentDto(c);
//            dtos.add(d);
//        }
//
//        // 반환 : DTO
//        return dtos;
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        // 게시글 조회 및 예외 발생 (게시글을 조회 하였는데 만약 없다면 예외를 발생 시켜라 (orElseThrow() 메서드)
        Board board = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! 해당 게시글이 없습니다."));

        // 댓글 엔티티 생성
        Comment comment = Comment.createComment(dto, board);

        // 댓글을 DB에 저장
        Comment created = commentRepository.save(comment);

        // DTO로 변경하여 반환
        return CommentDto.createCommentDto(created);
    }

    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        // 댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패 ! 조회 가능한 댓글이 없습니다."));

        // 댓글 수정
        target.patch(dto);

        // 댓글 DB 갱신
        Comment updated = commentRepository.save(target);

        // 댓글 엔티티를 DTO로 변환 및 반환
        return CommentDto.createCommentDto(updated);

    }

    @Transactional
    public CommentDto delete(Long id) {
        Comment target = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패 ! 조회 가능한 댓글이 없습니다."));

        commentRepository.delete(target);

        return CommentDto.createCommentDto(target);
    }
}
