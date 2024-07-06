package org.delivery.communitydh.domain.articledh.repository;


import java.util.List;
import org.delivery.communitydh.domain.articledh.entity.ArticledhEntity;
import org.delivery.communitydh.domain.boarddh.entity.BoarddhEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticledhRepository extends JpaRepository<ArticledhEntity, Long> {
  List<ArticledhEntity> findByBoard(BoarddhEntity board);
}
