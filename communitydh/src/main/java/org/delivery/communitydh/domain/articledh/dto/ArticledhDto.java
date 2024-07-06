package org.delivery.communitydh.domain.articledh.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticledhDto {

  private Long articlePk;
  private String boardName;
  private String title;
  private String content;
  private LocalDateTime createdAt;

}
