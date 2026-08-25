package com.example.imageboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JPA Auditing 활성화 (JPA 날짜 자동생성 기능 사용)
public class ImageboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageboardApplication.class, args);
    }

}
