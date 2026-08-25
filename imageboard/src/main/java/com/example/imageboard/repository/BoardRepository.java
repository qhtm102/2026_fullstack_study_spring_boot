package com.example.imageboard.repository;

import com.example.imageboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board, Long> {
    // JOIN FETCH — 연관 Entity를 한 번에 조회 (N+1 문제 해결)
    @Query("SELECT b FROM Board b JOIN FETCH b.member ORDER BY b.createdAt DESC")
    List<Board> findAllWithMember();
}
