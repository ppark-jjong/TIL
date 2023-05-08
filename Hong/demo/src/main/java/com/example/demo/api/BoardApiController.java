package com.example.demo.api;

import com.example.demo.dto.BoardForm;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import com.example.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //로깅을 위한 애노테이션
@RestController //Rest용 컨트롤러 애노테이션 데이터(JSON) 을 반환한다.
public class BoardApiController {
    @Autowired //DI 스프링이 관리하는 Bean을 자동으로 삽입
    private BoardService BoardService;

    //GET 요청 Select
    @GetMapping("/api/Boards")
    public List<Board> index() {
        return BoardService.index();
    }

    @GetMapping("/api/Boards/{id}")
    public Board show(@PathVariable Long id,
                         Model model) { // URL에서 id를 변수로 가져옴
        return BoardService.show(id);
    }
    // POST
    @PostMapping("/api/Boards")
    public ResponseEntity<Board> create(@RequestBody BoardForm dto) {
        Board created = BoardService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //PATCH 요청 Update
    @PatchMapping("/api/Boards/{id}")
    public ResponseEntity<Board> update(@PathVariable Long id,
                                          @RequestBody BoardForm dto) {
        Board updated = BoardService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } 

    //DELETE 요청 Delete
    @DeleteMapping("/api/Boards/{id}")
    public ResponseEntity<Board> delete(@PathVariable Long id) {
        Board deleted = BoardService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 트랜잭션 -> 실패 -> 롤백 !
    // 만약 이 트랜잭션 단계에서 하나라도 실패가 된다면 그 데이터는 DB에 저장되거나 처리되어서는 안된다
    // 따라서 그런 불상사를 막고자 무조건 처음 단계로 돌아가게 하는 롤백을 실현 시켜야 된다.
    // 이 해당 내용을 가능하게 하는 것이 트랜잭션 애노테이션이다.
    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Board>> transactionTest(@RequestBody List<BoardForm> dtos) { //여러개의 데이터를 한번에 받기
        List<Board> createdList = BoardService.createBoards(dtos); //여러개 데이터를 List 형식으로 받는다
        return (createdList != null) ? //만약 리스트 반환 값이 null 일 경우 다시 말해 실패할때 오류 메세지 아닐 때 성공 메세지와 함꼐 저장된 리스트 보여주기
                ResponseEntity.status(HttpStatus.OK).body(createdList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}