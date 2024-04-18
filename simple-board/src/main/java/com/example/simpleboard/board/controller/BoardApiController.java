package com.example.simpleboard.board.controller;


import com.example.simpleboard.board.db.BoardEntity;
import com.example.simpleboard.board.model.BoardRequest;
import com.example.simpleboard.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("")
    public BoardEntity create(
        @Valid // 디펜던시에 추가 >> implementation 'org.springframework.boot:spring-boot-starter-validation'
        @RequestBody
        BoardRequest boardRequest
    ){
        return boardService.create(boardRequest);
    }
}
