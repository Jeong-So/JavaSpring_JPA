package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest  // spring 콘텐츠를 로딩하여 Test에 활용
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        userRepository.save(new User());  // @NoArgsConstructor 활용 User()을 생성하고 userRepository(Table)에 저장

        System.out.println(">>> " + userRepository.findAll()); // user라는 테이블에 있는 모든 데이터를 리스트 형태로 가져오겠다
    }

}