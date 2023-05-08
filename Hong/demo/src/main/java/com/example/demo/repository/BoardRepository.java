package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
public interface BoardRepository extends CrudRepository<Board, Long> {
    @Override
    ArrayList<Board> findAll();
}