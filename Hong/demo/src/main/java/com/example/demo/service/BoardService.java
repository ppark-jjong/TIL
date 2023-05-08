package com.example.demo.service;

import com.example.demo.dto.BoardForm;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BoardService {
    private BoardRepository BoardRepository;

    public List<Board> index() {
        return BoardRepository.findAll();
    }

    public Board show(Long id) {
        return BoardRepository.findById(id).orElse(null);
    }

    public Board create(BoardForm dto) {
        Board Board = dto.toEntity();
        //만약 이미 존재하는 id를 생성한다면 그것은 Update이므로 생성요청인 Post와 맞지 않다.
        //따라서 밑의 로직을 따른다.
        if (Board.getId() != null) {
            return null;
        }
        return BoardRepository.save(Board);
    }

    public Board update(Long id, BoardForm dto) {
        // 1: DTO -> 엔티티
        Board Board = dto.toEntity();
        log.info("id: {}, Board: {}", id, Board.toString());
        // 2: 타겟 조회
        Board target = BoardRepository.findById(id).orElse(null);
        // 3: 잘못된 요청 처리
        if (target == null || id != Board.getId()) {
            // 400, 잘못된 요청 응답!
            log.info("잘못된 요청! id: {}, Board: {}", id, Board.toString());
            return null;
        }
        // 4: 업데이트
        target.patch(Board);
        Board updated = BoardRepository.save(target);
        return updated;
    }

    public Board delete(Long id) {
        // 대상 찾기
        Board target = BoardRepository.findById(id).orElse(null);
        // 잘못된 요청 처리
        if (target == null) {
            return null;
        }
        // 대상 삭제
        BoardRepository.delete(target);
        return target;
    }

    @Transactional
    public List<Board> createBoards(List<BoardForm> dtos) {
        // dto 묶음을 entity 묶음으로 변환
        List<Board> BoardList = dtos.stream()//stream 문법 사용
                .map(dto -> dto.toEntity())//다수의 dto들을 하나로 매핑 한다
                .collect(Collectors.toList()); //매핑 된것을 리스트로 변화한다.
//
//        만약 for 문으로 작성한다면
//        List<Board> BoardList = new ArrayList<>();
//        for (int i = 0; i < dtos.size(); i++) {
//            BoardForm dto = dtos.get(i);
//            Board entity = dto.toEntity();
//            BoardList.add(entity);
//        }

        // entity 묶음을 DB로 저장
        BoardList.stream()
                .forEach(Board -> BoardRepository.save(Board));

        // 강제 예외 발생
        BoardRepository.findById(-1L).orElseThrow(
                () -> new IllegalArgumentException("결제 실패!")
        );

        // 결과값 반환
        return BoardList;
    }
}
