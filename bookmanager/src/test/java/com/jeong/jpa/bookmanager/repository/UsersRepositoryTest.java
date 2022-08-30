package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.Users;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest  // spring 콘텐츠를 로딩하여 Test에 활용
class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
//    @Transactional  // 6. getOne
    void crud() {

        // 1. 저장(insert = save) 조회(select = findAll)

//        usersRepository.save(new Users());  // @NoArgsConstructor 활용 User()을 생성하고 userRepository(Table)에 저장
//
////        System.out.println(">>> " + usersRepository.findAll()); // 방법 1 : users라는 테이블에 있는 모든 데이터를 리스트 형태로 가져오겠다
//        usersRepository.findAll().forEach(System.out::println); // 방법 2
//        // 방법 3 (=방법 2)
//        /*
//        for (Users users : usersRepository.findAll()) {
//            System.out.println(users);
//        }
//         */

        // 2. 조회(select = findAll)
//        List<Users> users = usersRepository.findAll();
//        users.forEach(System.out::println);


        // 3. 이름을 기준으로 내림차순으로 조회  : findAll(Sort.by(Sort.Direction.DESC,"name"))
//        List<Users> users = usersRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
//        users.forEach(System.out::println);

        // 4. findAllById
        // 방법 1) id를 넣는 변수 ids를 만들어서 그 변수를 통해 findAllById 함 (1,3,5번 찾기)
//        List<Long> ids = new ArrayList<>();
//        ids.add(1L);
//        ids.add(3L);
//        ids.add(5L);
//        List<Users> users = usersRepository.findAllById(ids);

        // 방법 2) findAllById(Lists.newArrayList(1L,3L,5L)) (= 방법 1)
//        List<Users> users = usersRepository.findAllById(Lists.newArrayList(1L,3L,5L));
//
//        users.forEach(System.out::println);


        // 5. 저장(insert = save)
//        Users user1 = new Users("jack", "jack@naver.com");
//        Users user2 = new Users("steve","steve@naver.com");
//
////        usersRepository.saveAll(Lists.newArrayList(user1, user2));  // 1
//        usersRepository.save(user1);  // 2
//
//        List<Users> users = usersRepository.findAll();
//        users.forEach(System.out::println);
//        // data.sql에 call next value for hibernate_sequence; 이 없으면 savd 시 오류
//        // id를 1부터 넣기 때문

        // 6. getOne : id 가져오기  -- 세션유지를 위해 @Transactional 을 붙여야 함  //  Entity에 대해 lazy한 로직(Lazy한 패치) 지원
//            Users users = usersRepository.getOne(1L);
//            System.out.println(users);

        // 7. findById릉 통해 id 1번을 가져오며 오류  --> return되는 객체가 optional로 한번 맵핑 되어있음  // Eager 패치
        Optional<Users> users = usersRepository.findById(1L); // 방법 1
//        Users users = usersRepository.findById(1L).orElse(null);  // 방법 2 : id가 1인 객체 미존재시 orElse로 null 반납
        System.out.println(users);

        // getOne(lazy) vs findById(Eager) 비교 필요

    }

}