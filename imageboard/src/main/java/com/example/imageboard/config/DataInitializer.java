package com.example.imageboard.config;

import com.example.imageboard.entity.Member;
import com.example.imageboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

// DataInitializer.java 수정
@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;  // 추가

    @Override
    public void run(ApplicationArguments args) {
        if (memberRepository.count() == 0) {
            memberRepository.save(
                    Member.create(
                            "admin",
                            passwordEncoder.encode("password123"),   // 암호화 적용
                            "관리자"
                    )
            );
        }
    }
}

