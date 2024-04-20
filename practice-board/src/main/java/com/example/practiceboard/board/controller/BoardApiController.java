package com.example.practiceboard.board.controller;


import com.example.practiceboard.board.db.BoardEntity;
import com.example.practiceboard.board.dto.BoardRequest;
import com.example.practiceboard.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/practiceboard")
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
