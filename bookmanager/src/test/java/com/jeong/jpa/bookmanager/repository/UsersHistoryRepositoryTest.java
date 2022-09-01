package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersHistoryRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersHistoryRepository usersHistoryRepository;

    @Test
    void userHistoryTest() {
        Users users = new Users();
        users.setEmail("jeong2@hanmail.com");
        users.setName("jeong2");

        usersRepository.save(users);

        users.setName("jeong222");

        usersRepository.save(users);

        usersHistoryRepository.findAll().forEach(System.out::println);
    }
}