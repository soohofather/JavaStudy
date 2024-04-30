package com.example.boardwithhan.service;

import com.example.boardwithhan.entity.Board;
import com.example.boardwithhan.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 글 작성
    public void write(Board board){

        boardRepository.save(board);

    }

    // 리스트
    public List<Board> boardList() {

        return boardRepository.findAll();
    }

    // 게시글 상세
    public Board boardView(Integer id) {

        return boardRepository.findById(id).get();
    }


}
