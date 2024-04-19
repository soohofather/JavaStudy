package com.example.simpleboard.reply.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {


    // SELECT * FROM REPLY WHERE POST_ID = ? AND STATUS = ? ORDER BY ID DESC
    List<ReplyEntity> findAllByPostIdAndStatusOrderByIdDesc(Long postId, String status);
}
