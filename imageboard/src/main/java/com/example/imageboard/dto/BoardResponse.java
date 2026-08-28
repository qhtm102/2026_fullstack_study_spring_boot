package com.example.imageboard.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

// BoardResponse.java 수정
@Getter
@Builder
public class BoardResponse {

    private Long id;
    private String title;
    private String content;
    private String author;
    private Long memberId;       // 추가 — 작성자 ID (뷰에서 권한 비교용)
    private int viewCount;
    private String thumbnailUrl;
    private List<ImageResponse> images;    // 추가
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Getter
    @Builder
    public static class ImageResponse {
        private Long id;
        private String originalName;
        private String storedName;
    }
}


