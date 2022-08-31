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

        // IsNotEmpty() : Address 사용시 null 넣어줌,  findByAllowTrue() :  allow 값(boolean 넣어줌
        Users users1 = new Users(null,"jeong","jeong@naver.com", LocalDateTime.now(), LocalDateTime.now(), true, null); //id 값 필요
        Users users2 = new Users("jeong","jeong@naver.com");

        Users users3 = Users.builder()
                .name("jeong")
                .email("jeong@naver.com")
                .build();

        System.out.println(">>> " + users.toString());
    }
}
