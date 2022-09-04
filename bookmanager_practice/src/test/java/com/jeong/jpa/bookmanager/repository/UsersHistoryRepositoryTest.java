package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.Gender;
import com.jeong.jpa.bookmanager.domain.Users;
import com.jeong.jpa.bookmanager.domain.UsersHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void userOneToManyRelationTest() {
        Users user = new Users();
        user.setName("david");
        user.setEmail("david@daum.net");
        user.setGender(Gender.MALE);
        usersRepository.save(user);

        user.setName("daniel");
        usersRepository.save(user);

        user.setEmail("daniel@naver.com");
        usersRepository.save(user);

        usersHistoryRepository.findAll().forEach(System.out::println);

//        List<UsersHistory> result = usersHistoryRepository.findByUsersId(
//            usersRepository.findByEmail("daniel@naver.com").getId());

        List<UsersHistory> result = usersRepository.findByEmail("daniel@naver.com").getUsersHistories();

        result.forEach(System.out::println);

        System.out.println("UserHistory.getUser() : " + usersHistoryRepository.findAll().get(0).getUsers());
    }
}