package com.example.imageboard.service;

import com.example.imageboard.dto.BoardCreateRequest;
import com.example.imageboard.dto.BoardResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.LongStream;

@Service
public class BoardService {

    // ── 임시 더미 데이터 (4장에서 JPA로 교체) ──────────────────────────
    private List<BoardResponse> getDummyList() {
        return LongStream.rangeClosed(1, 10)
                .mapToObj(i -> BoardResponse.builder()
                        .id(i)
                        .title("게시글 제목 " + i)
                        .content("게시글 내용입니다. " + i)
                        .author("작성자" + i)
                        .viewCount((int) (i * 10))
                        .thumbnailUrl(null)
                        .createdAt(LocalDateTime.now().minusDays(i))
                        .build())
                .toList();
    }
    // ─────────────────────────────────────────────────────────────────────

    /** 게시글 목록 조회 */
    public List<BoardResponse> findAll() {
        return getDummyList();
    }

    /** 게시글 단건 조회 */
    public BoardResponse findById(Long id) {
        return getDummyList().stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다. id=" + id));
    }

    /** 게시글 등록 (4장에서 실제 저장 로직으로 교체) */
    public Long create(BoardCreateRequest request) {
        // 더미: 저장 후 id 1L 반환
        return 1L;
    }

}
