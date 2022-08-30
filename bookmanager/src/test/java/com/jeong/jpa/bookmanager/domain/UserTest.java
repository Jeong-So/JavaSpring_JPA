package com.jeong.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class UserTest {

    @Test
    void test() {
        User user = new User();
        user.setEmail("jeong@naver.com");
        user.setName("jeong");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User user1 = new User(null,"jeong","jeong@naver.com", LocalDateTime.now(), LocalDateTime.now()); //id 값 필요
        User user2 = new User("jeong","jeong@naver.com");

        User user3 = User.builder()
                .name("jeong")
                .email("jeong@naver.com")
                .build();

        System.out.println(">>> " + user.toString());
    }
}
