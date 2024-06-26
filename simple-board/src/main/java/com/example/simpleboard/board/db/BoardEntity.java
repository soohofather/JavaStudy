package com.example.simpleboard.board.db;

import com.example.simpleboard.post.db.PostEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String BoardName;
    private String status;

    @OneToMany(
            mappedBy = "board" // 이 변수의 명은 PostEntity에 가면 있어야함.
    )
    @Builder.Default
    @Where(clause = "status = 'REGISTERED'") // 상태값이 REGISTERED만 보이게 하기
//    @OrderBy(clause = "id desc") 안먹네..
    private List<PostEntity> postList = List.of();
}

