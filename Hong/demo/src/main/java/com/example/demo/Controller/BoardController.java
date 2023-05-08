package com.example.demo.Controller;

import com.example.demo.dto.BoardForm;
import com.example.demo.dto.CommentDto;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import com.example.demo.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j //로깅을 위한 애노테이션
public class BoardController {

    @Autowired // 스프링 부트가 미리 생성해놓은 리파지터리 객체를 가져옴(DI)
    private BoardRepository BoardRepository;

    @Autowired
    private CommentService commentService;

    @GetMapping("/Boards/new")
    public String newBoardForm() {
        return "Boards/new";
    }

    @PostMapping("/Boards/create")
    public String createBoard(BoardForm form) {
        log.info(form.toString());

        // 1. Dto를 Entity 변환
        Board Board = form.toEntity();

        // 2. Repository에게 Entity를 DB로 저장하게 함
        Board saved = BoardRepository.save(Board);
        log.info(saved.toString());
        // 리다이렉트 적용: 생성 후, 브라우저가 해당 URL로 재요청
        return "redirect:/Boards/" + saved.getId();

    }
    @GetMapping("/Boards/{id}") // 해당 URL요청을 처리 선언 (특정 데이터만 불러오기)
    public String show(@PathVariable Long id,
                       Model model) { // URL에서 id를 변수로 가져옴
        log.info("id = " + id);
        // 1: id로 데이터를 가져옴!
        Board BoardEntity = BoardRepository.findById(id).orElse(null);
        List<CommentDto> commentsDtos = commentService.comments(id);

        // 2: 가져온 데이터를 모델에 등록!
        model.addAttribute("Board", BoardEntity);
        model.addAttribute("commentDtos", commentsDtos);

        // 3: 보여줄 페이지를 설정!
        return "Boards/show";
    }

    @GetMapping("/Boards")
    public String index(Model model) {
        // 1: 모든 Board을 가져온다!
        List<Board> BoardEntityList = BoardRepository.findAll();
        // 2: 가져온 Board 묶음을 뷰로 전달!
        model.addAttribute("BoardList", BoardEntityList);
        // 3: 뷰 페이지를 설정!
        return "Boards/index";
    }
    @GetMapping("/Boards/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        //수정할 데이터 가져오기
        Board BoardEntity = BoardRepository.findById(id).orElse(null);
        //모델에 데이터 등록
        model.addAttribute("Board", BoardEntity);
        //뷰 페이지 설정
        return "Boards/edit";
    }

    @GetMapping("/Boards/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제 요청");
        // 1: 삭제 대상을 가져옴
        Board target = BoardRepository.findById(id).orElse(null);
        log.info(target.toString());
        // 2: 대상을 삭제
        if(target !=null)
        {
            BoardRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제 되었습니다.");
        }
        // 3: 결과 페이지를 리다이렉트
        return "redirect:/Boards";
    }


    @PostMapping("/Boards/update")
    public String update(BoardForm form){
        // 폼데이터(DTO)를 엔티티로 변경
        Board BoardEntity = form.toEntity();

        // 엔티티를 DB에 저장
        // DB에 기존 데이터를 가져옴
        Board target = BoardRepository.findById(BoardEntity.getId()).orElse(null);
        //기존의 데이터 값 갱신
        if(target !=null){
            BoardRepository.save(BoardEntity);
        }
        // 수정 결과 리턴 페이지
        return "redirect :/Boards" + BoardEntity.getId();
    }
}