package com.example.demo.service;

import com.example.demo.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 해당 클래스는 스프링부트와 연동되어 테스트 된다.
class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Test
        //테스트 코드이다 라는 애노테이션
    void index() {
        //예상 시나리오
        Article a = new Article(2L, "오늘의 날짜는", "123");
        Article b = new Article(3L, "1414", "1414");
        Article c = new Article(4L, "aaaaa", "aaaaa");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        //실제 결과
        List<Article> articles = boardService.index();

        //검증
        assertEquals(expected.toString(), articles.toString());
    }
}