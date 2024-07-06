package org.delivery.communitydh.domain.boarddh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "boarddh", schema = "communitydh")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BoarddhEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardPk;
    private String boardName;

}
