package org.delivery.communitydh.domain.articledh.service.Impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.delivery.communitydh.domain.articledh.dto.ArticledhCreateDto;
import org.delivery.communitydh.domain.articledh.dto.ArticledhDto;
import org.delivery.communitydh.domain.articledh.dto.ArticledhResponseDto;
import org.delivery.communitydh.domain.articledh.entity.ArticledhEntity;
import org.delivery.communitydh.domain.articledh.repository.ArticledhRepository;
import org.delivery.communitydh.domain.articledh.service.ArticledhService;
import org.delivery.communitydh.domain.boarddh.entity.BoarddhEntity;
import org.delivery.communitydh.domain.boarddh.repository.BoarddhRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticledhServiceImpl implements ArticledhService {

  private final ArticledhRepository articledhRepository;
  private final BoarddhRepository boarddhRepository;

  // 게시글 생성
  @Override
  @Transactional
  public ArticledhResponseDto create(ArticledhCreateDto articledhCreateDto, Long boardPk) {


    BoarddhEntity boarddhEntity = boarddhRepository.findById(boardPk)
        .orElseThrow(() -> new NoSuchElementException("Board not found with ID: " + boardPk));

    ArticledhEntity entity = ArticledhEntity.builder()
        .board(boarddhEntity)
        .title(articledhCreateDto.getTitle())
        .content(articledhCreateDto.getContent())
        .build();

    ArticledhEntity savedEntity = articledhRepository.save(entity);

    ArticledhResponseDto article = ArticledhResponseDto.builder()
        .articlePk(savedEntity.getArticlePk())
        .build();

    return article;
  }

  // 게시글 목록
  @Override
  public List<ArticledhDto> list(Long boardPk) {
    List<ArticledhDto> articles;

    if (boardPk == null) {
      articles = articledhRepository.findAll().stream()
          .map(entity -> ArticledhDto.builder()
              .articlePk(entity.getArticlePk())
              .boardName(entity.getBoard().getBoardName())
              .title(entity.getTitle())
              .content(entity.getContent())
              .createdAt(entity.getCreatedAt())
              .build())
          .collect(Collectors.toList());
    } else {
      BoarddhEntity boarddhEntity = boarddhRepository.findById(boardPk)
          .orElseThrow(() -> new NoSuchElementException("Board not found with ID: " + boardPk));

      articles = articledhRepository.findByBoard(boarddhEntity).stream()
          .map(entity -> ArticledhDto.builder()
              .articlePk(entity.getArticlePk())
              .boardName(entity.getBoard().getBoardName())
              .title(entity.getTitle())
              .content(entity.getContent())
              .createdAt(entity.getCreatedAt())
              .build())
          .collect(Collectors.toList());
    }

    return articles;
  }

  // 게시글 삭제
  @Override
  @Transactional
  public void delete(Long articlePk) {

    ArticledhEntity articledhEntity = articledhRepository.findById(articlePk)
        .orElseThrow(() -> new NoSuchElementException("Article not found with ID: " + articlePk));
    articledhRepository.delete(articledhEntity);
  }

}