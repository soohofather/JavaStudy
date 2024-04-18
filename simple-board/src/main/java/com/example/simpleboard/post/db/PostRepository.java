package com.example.simpleboard.post.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    // SELECT * FROM POST WHERE ID = ? AND STATUS = ? ORDER BY ID DESC LIMIT 1
    public Optional<PostEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, String status);
}
