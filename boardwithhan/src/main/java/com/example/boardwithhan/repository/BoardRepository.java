package com.example.boardwithhan.repository;


import com.example.boardwithhan.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository  extends JpaRepository<Board, Integer> {
}
