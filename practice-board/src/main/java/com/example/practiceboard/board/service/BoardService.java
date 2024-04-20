package com.example.practiceboard.board.service;


import com.example.practiceboard.board.db.BoardEntity;
import com.example.practiceboard.board.dto.BoardRequest;
import lombok.RequiredArgsConstructor;
import com.example.practiceboard.board.db.BoardRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardEntity create(
            BoardRequest boardRequest
    ){
        var entity = BoardEntity.builder()
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build()
                ;

        return boardRepository.save(entity);
    }
}
