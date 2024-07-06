package org.delivery.communitydh.domain.boarddh.service;


import lombok.RequiredArgsConstructor;
import org.delivery.communitydh.domain.boarddh.dto.BoarddhCreateDto;
import org.delivery.communitydh.domain.boarddh.dto.BoarddhDto;
import org.delivery.communitydh.domain.boarddh.entity.BoarddhEntity;
import org.delivery.communitydh.domain.boarddh.repository.BoarddhRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoarddhService {

  private final BoarddhRepository boarddhRepository;

  // 게시판 생성
  public BoarddhDto create(BoarddhCreateDto boarddhCreateDto) {
    BoarddhEntity entity = BoarddhEntity.builder()
        .boardName(boarddhCreateDto.getBoardName())
        .build();

    BoarddhEntity savedEntity = boarddhRepository.save(entity);
    return BoarddhDto.builder()
        .boardPk(savedEntity.getBoardPk())
        .boardName(savedEntity.getBoardName())
        .build();
  }

}
