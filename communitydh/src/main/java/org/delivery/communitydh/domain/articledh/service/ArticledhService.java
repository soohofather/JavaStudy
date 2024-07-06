package org.delivery.communitydh.domain.articledh.service;


import java.util.List;
import org.delivery.communitydh.domain.articledh.dto.ArticledhCreateDto;
import org.delivery.communitydh.domain.articledh.dto.ArticledhDto;
import org.delivery.communitydh.domain.articledh.dto.ArticledhResponseDto;

public interface ArticledhService {

  ArticledhResponseDto create(ArticledhCreateDto articledhCreateDto, Long boardPk);

  List<ArticledhDto> list(Long boardPk);

  void delete(Long boardPk);
}
