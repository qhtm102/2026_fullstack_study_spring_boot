package com.example.imageboard.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder // 각 필드 별로 값 저장하는 함수 자동 구현
public class BoardResponse {

    private Long id;
    private String title;
    private String content;
    private String author;
    private int viewCount;
    private String thumbnailUrl;     // 대표 이미지 경로
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
