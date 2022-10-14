package com.ll.jwt.app.base;


import com.ll.jwt.app.member.entity.Member;
import com.ll.jwt.app.member.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile("test")
public class TestInitData {
    @Bean
    public CommandLineRunner initData(MemberService memberService, PasswordEncoder passwordEncoder) {
        String password = passwordEncoder.encode("1234");
        return args -> {
            Member member1 = memberService.join("user1", password, "ddmkim94@gmail.com");
            Member member2 = memberService.join("user2", password, "eunbin92@gmail.com");
        };
    }
}
