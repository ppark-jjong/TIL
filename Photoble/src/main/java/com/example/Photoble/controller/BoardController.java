package com.example.Photoble.controller;

import com.example.Photoble.entity.Board;
import com.example.Photoble.entity.customEntity.BoardPrint;
import com.example.Photoble.entity.Image;
import com.example.Photoble.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("board/main")
    public String boardMain(HttpSession session, Model model, String searchKeyword){
        if (session.getAttribute("userName") == null){
            return "redirect:/login";
        }

        List<BoardPrint> list = null;

        try {
            if(searchKeyword.isBlank()) {
                searchKeyword = null;
            }
        }
        catch (Exception e){

        }

        if(searchKeyword == null){
            list = boardService.boardlist();

        }else {
            list = boardService.boardSelectList(searchKeyword);
        }

        Collections.reverse(list);

        model.addAttribute("searchKeyword", searchKeyword);
        model.addAttribute("list", list);

        return  "board/board_main";
    }

    @GetMapping("/board/upload")
    public String getBoardUpload(HttpSession session, Model model) {
        if (session.getAttribute("userName") == null){
            return "redirect:/login";
        }

        List<Image> list = null;

        list = boardService.returnImage(session);
        model.addAttribute("list", list);

        return "board/board_upload";
    }

    @PostMapping("/board/uploading")
    public String postBoardUpload(HttpSession session, Board board, Model model, String ...selectImage) throws Exception{

        List<String> list = new ArrayList<String>();

        for (String str : selectImage) {
            list.add(str);
        }

        boardService.boardWrite(board, session, list);
        return  "redirect:/board/main";
    }

    @GetMapping("/board/view")
    public String boardView(HttpSession session, Model model, Integer id) {
        if (session.getAttribute("userName") == null){
            return "redirect:/login";
        }

        model.addAttribute("comments", boardService.commentsView(id));
        model.addAttribute("board", boardService.boardView(id));
        model.addAttribute("cnt", boardService.commentsView(id).size());
        model.addAttribute("nowUser", session.getAttribute("userName").toString());
        return "board/board_view";
    }

    @PostMapping("/comment/uploding")
    public String postComment(HttpSession session, String content, String board){

        boardService.commentWirte(session, content, board);
        return "redirect:/board/view?id="+board;
    }

    @PostMapping("/comment/remove")
    public String removeComment(Integer commentId, String board){
        boardService.commentRemove(commentId);
        return "redirect:/board/view?id="+board;
    }

    @GetMapping("/board/remove")
    public String removeBoard(Integer id, Model model){

        boardService.boardRemove(id);

        model.addAttribute("title", "Success!");
        model.addAttribute("message","게시글 삭제 성공");
        model.addAttribute("url", "/board/main");

        return "sub/alert";
    }
}
