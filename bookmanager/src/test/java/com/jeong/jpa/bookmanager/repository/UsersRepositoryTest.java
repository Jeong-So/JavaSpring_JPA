package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest  // spring 콘텐츠를 로딩하여 Test에 활용
class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void crud() {
        usersRepository.save(new Users());  // @NoArgsConstructor 활용 User()을 생성하고 userRepository(Table)에 저장

        System.out.println(">>> " + usersRepository.findAll()); // user라는 테이블에 있는 모든 데이터를 리스트 형태로 가져오겠다
    }

}