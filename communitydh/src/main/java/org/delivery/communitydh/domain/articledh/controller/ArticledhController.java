package org.delivery.communitydh.domain.articledh.controller;


import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.delivery.communitydh.domain.articledh.dto.ArticledhCreateDto;
import org.delivery.communitydh.domain.articledh.dto.ArticledhDto;
import org.delivery.communitydh.domain.articledh.dto.ArticledhResponseDto;
import org.delivery.communitydh.domain.articledh.service.ArticledhService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/communitydh")
public class ArticledhController {

  private final ArticledhService articledhService;

  @PostMapping("/{boardPk}")
  public ArticledhResponseDto create(

      @Valid
      @RequestBody
      ArticledhCreateDto articledhCreateDto,

      @PathVariable
      Long boardPk

  ) {
    return articledhService.create(articledhCreateDto, boardPk);
  }

  @GetMapping("")
  public List<ArticledhDto> list(@RequestParam(required = false) Long boardPk) {

    return articledhService.list(boardPk);
  }

  @DeleteMapping("/{articlePk}")
  public Void delete(@PathVariable Long articlePk) {

    articledhService.delete(articlePk);
    return null;
  }

}