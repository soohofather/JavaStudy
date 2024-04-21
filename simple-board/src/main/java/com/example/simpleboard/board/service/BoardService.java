package com.example.simpleboard.board.service;


import com.example.simpleboard.board.db.BoardEntity;
import com.example.simpleboard.board.db.BoardRepository;
import com.example.simpleboard.board.model.BoardDto;
import com.example.simpleboard.board.model.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// Repository와 연결 시켜줌
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository; // final 이 붙어야 argument, 기본 생성자의 해당 값이 들어가서 생성 됨
    private final BoardConverter boardConverter;

    public BoardDto create(
            BoardRequest boardRequest
    ){
        var entity = BoardEntity.builder()
            .BoardName(boardRequest.getBoardName())
            .status("REGISTERED")
            .build()
            ;

        var saveEntity = boardRepository.save(entity);

        return boardConverter.toDto(saveEntity);
    }

    public BoardDto view(Long id) {
        var entity = boardRepository.findById(id).get();
        return boardConverter.toDto(entity);
    }
}
