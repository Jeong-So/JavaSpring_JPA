package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.Users;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest  // spring 콘텐츠를 로딩하여 Test에 활용
class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
//    @Transactional  // 6. getOne
    void crud() {

        // insert 쿼리
        usersRepository.save(new Users("david", "david@naver.com"));

        Users user = usersRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("jeong-updated@naver.com");

        // update 쿼리
        usersRepository.save(user);

        usersRepository.findAll().forEach(System.out::println);
    }

    @Test
    void select(){
        System.out.println(usersRepository.findByName("jeong"));

        System.out.println("findByEmail : " + usersRepository.findByEmail("jeong@naver.com"));
        System.out.println("getByEmail : " + usersRepository.getByEmail("jeong@naver.com"));
        System.out.println("readByEmail : " + usersRepository.readByEmail("jeong@naver.com"));
        System.out.println("queryByEmail : " + usersRepository.queryByEmail("jeong@naver.com"));
        System.out.println("searchByEmail : " + usersRepository.searchByEmail("jeong@naver.com"));
        System.out.println("streamByEmail : " + usersRepository.streamByEmail("jeong@naver.com"));
        System.out.println("findUserByEmail : " + usersRepository.findUserByEmail("jeong@naver.com"));

        System.out.println("findSomethingByEmail : " + usersRepository.findSomethingByEmail("jeong@naver.com"));

        System.out.println("findTop2ByName : " + usersRepository.findTop2ByName("jeong"));
        System.out.println("findFirst2ByName : " + usersRepository.findFirst2ByName("jeong"));
        System.out.println("findLast1ByName : " + usersRepository.findLast1ByName("jeong"));

    }

}