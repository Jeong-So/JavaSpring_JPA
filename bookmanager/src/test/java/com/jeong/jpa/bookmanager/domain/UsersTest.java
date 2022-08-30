package com.jeong.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class UsersTest {

    @Test
    void test() {
        Users users = new Users();
        users.setEmail("jeong@naver.com");
        users.setName("jeong");
        users.setCreatedAt(LocalDateTime.now());
        users.setUpdatedAt(LocalDateTime.now());

        Users users1 = new Users(null,"jeong","jeong@naver.com", LocalDateTime.now(), LocalDateTime.now()); //id 값 필요
        Users users2 = new Users("jeong","jeong@naver.com");

        Users users3 = Users.builder()
                .name("jeong")
                .email("jeong@naver.com")
                .build();

        System.out.println(">>> " + users.toString());
    }
}
