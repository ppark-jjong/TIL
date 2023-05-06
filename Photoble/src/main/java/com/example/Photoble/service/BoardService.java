package com.example.Photoble.service;

import com.example.Photoble.SubClass.DateNow;
import com.example.Photoble.entity.*;
import com.example.Photoble.entity.customEntity.BoardPrint;
import com.example.Photoble.entity.customEntity.ImageTagPrint;
import com.example.Photoble.repository.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImagetagRepository imagetagRepository;

    @Autowired
    private BoardimageRepository boardimageRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    public List<BoardPrint> boardlist() {
        List<Board> boardList = boardRepository.findAll();

        List<BoardPrint> boardPrintList = new ArrayList<>();

        for (Board board : boardList) {
            BoardPrint boardPrint = new BoardPrint();

            boardPrint.setId(board.getId());
            boardPrint.setTitle(board.getTitle());
            boardPrint.setUser(board.getUser());
            boardPrint.setDate(board.getDate());

            List<ImageTagPrint> imageTagPrintList = new ArrayList<>();

            for (BoardImage boardImage: boardimageRepository.findByBoard(board.getId())) {
                ImageTagPrint imageTagPrint = new ImageTagPrint();

                imageTagPrint.setImage(boardImage.getImage());

                String tag = "";
                for (ImageTag imageTag: imagetagRepository.findByImage(imageRepository.findByImagepath(boardImage.getImage()).getImagename())) {
                    tag += " #"+imageTag.getTag();
                }

                imageTagPrint.setTag(tag.trim());

                imageTagPrintList.add(imageTagPrint);
            }

            boardPrint.setImageTagPrintList(imageTagPrintList);

            boardPrintList.add(boardPrint);
        }

        return boardPrintList;
    }

    public List<BoardPrint> boardSelectList(String searchKeyword){
        List<Board> boardList = boardRepository.findByTitleContaining(searchKeyword);

        List<BoardPrint> boardPrintList = new ArrayList<>();

        for (Board board : boardList) {
            BoardPrint boardPrint = new BoardPrint();

            boardPrint.setId(board.getId());
            boardPrint.setTitle(board.getTitle());
            boardPrint.setUser(board.getUser());
            boardPrint.setDate(board.getDate());

            List<ImageTagPrint> imageTagPrintList = new ArrayList<>();

            for (BoardImage boardImage: boardimageRepository.findByBoard(board.getId())) {
                ImageTagPrint imageTagPrint = new ImageTagPrint();

                imageTagPrint.setImage(boardImage.getImage());

                String tag = "";
                for (ImageTag imageTag: imagetagRepository.findByImage(imageRepository.findByImagepath(boardImage.getImage()).getImagename())) {
                    tag += " #"+imageTag.getTag();
                }

                imageTagPrint.setTag(tag);

                imageTagPrintList.add(imageTagPrint);
            }

            boardPrint.setImageTagPrintList(imageTagPrintList);

            boardPrintList.add(boardPrint);
        }

        return boardPrintList;
    }

    public List<Image> returnImage(HttpSession session){
        List<Image> list = imageRepository.findByUser(session.getAttribute("userName").toString());

        return  list;
    }

    public void boardWrite(Board board, HttpSession session, List<String> list) throws Exception{

        if(board.getTitle().equals("") || board.getTitle().isEmpty()){
            board.setTitle("제목 없음");
        }

        board.setUser(session.getAttribute("userName").toString());
        board.setDate(DateNow.timeNow());
        boardRepository.save(board);

        Integer id = boardRepository.findByTitleAndUserAndDate(board.getTitle(), board.getUser(), board.getDate()).getId();

        for (String image : list) {
            BoardImage boardImage = new BoardImage();
            boardImage.setBoard(id);
            boardImage.setImage(image);

            boardimageRepository.save(boardImage);
        }
    }

    public BoardPrint boardView(Integer id) {

        Board board = boardRepository.findById(id);

        BoardPrint boardPrint = new BoardPrint();

        boardPrint.setId(board.getId());
        boardPrint.setTitle(board.getTitle());
        boardPrint.setUser(board.getUser());
        boardPrint.setDate(board.getDate());

        List<ImageTagPrint> imageTagPrintList = new ArrayList<>();

        for (BoardImage boardImage: boardimageRepository.findByBoard(board.getId())) {
            ImageTagPrint imageTagPrint = new ImageTagPrint();

            imageTagPrint.setImage(boardImage.getImage());
            imageTagPrintList.add(imageTagPrint);
        }

        boardPrint.setImageTagPrintList(imageTagPrintList);

        return  boardPrint;
    }

    public List<Comments> commentsView(Integer id){

        return commentsRepository.findByBoard(id);
    }

    public void commentWirte(HttpSession session, String content, String board){
        Comments comments = new Comments();
        comments.setBoard(Integer.parseInt(board));
        comments.setUser(session.getAttribute("userName").toString());
        comments.setContent(content);
        comments.setDate(DateNow.timeNow());

        commentsRepository.save(comments);
    }

    public void commentRemove(Integer commentId){

        commentsRepository.deleteById(commentId);
    }

    public void boardRemove(Integer id){
        List<BoardImage> boardImageList = boardimageRepository.findByBoard(id);
        List<Comments> commentsList = commentsRepository.findByBoard(id);

        for (BoardImage boardImage: boardImageList) {
            boardimageRepository.delete(boardImage);
        }

        for (Comments comments: commentsList) {
            commentsRepository.delete(comments);
        }

        boardRepository.deleteById(Long.valueOf(id));
    }
}
