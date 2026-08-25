package com.example.imageboard.service;

import com.example.imageboard.dto.BoardCreateRequest;
import com.example.imageboard.dto.BoardResponse;
import com.example.imageboard.entity.Board;
import com.example.imageboard.entity.Member;
import com.example.imageboard.repository.BoardRepository;
import com.example.imageboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.LongStream;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    /** 게시글 목록 조회 */
    public List<BoardResponse> findAll() {
        return boardRepository.findAllWithMember().stream()
                .map(this::toResponse)
                .toList();
    }

    /** 게시글 단건 조회 */
    public BoardResponse findById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다. id=" + id));
        board.increaseViewCount(); // 변경 감지로 UPDATE 자동 실행
        return toResponse(board);
    }

    /** 게시글 등록 */
    public Long create(BoardCreateRequest request) {
        // 임시: 첫 번째 회원을 작성자로 설정 (6장 Spring Security 연동 후 변경)
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new IllegalStateException("회원이 없습니다."));

        Board board = Board.create(request.getTitle(), request.getContent(), member);
        boardRepository.save(board);
        return board.getId();
    }

    /** Entity → DTO 변환 */
    private BoardResponse toResponse(Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .author(board.getMember().getNickname())
                .viewCount(board.getViewCount())
                .thumbnailUrl(board.getThumbnailUrl())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }


}
