package org.delivery.communitydh.domain.boarddh.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.delivery.communitydh.domain.boarddh.dto.BoarddhCreateDto;
import org.delivery.communitydh.domain.boarddh.dto.BoarddhDto;
import org.delivery.communitydh.domain.boarddh.service.BoarddhService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/communitydh/board")
public class BoarddhController {

  private final BoarddhService boarddhService;

  @PostMapping("")
  public BoarddhDto create(

      @Valid
      @RequestBody
      BoarddhCreateDto boarddhCreateDto

  ) {

    return boarddhService.create(boarddhCreateDto);

  }

}
