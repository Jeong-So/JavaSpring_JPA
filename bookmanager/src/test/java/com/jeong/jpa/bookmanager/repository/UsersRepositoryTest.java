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
//        Optional<Users> users = usersRepository.findById(1L); // 방법 1
////        Users users = usersRepository.findById(1L).orElse(null);  // 방법 2 : id가 1인 객체 미존재시 orElse로 null 반납
//        System.out.println(users);

        // getOne(lazy) vs findById(Eager) 비교 필요

        // 8. flush / saveAndFlush : flush는 쿼리에 변화가 아닌 db반영 시점을 조절 (영속성 콘테스트 동작방법을 알면 알 수 있음)
        // 방법 1)
//        usersRepository.save(new Users("new jeong", "jeong2@naver.com"));
//        usersRepository.flush();
//        // 방법 2)
//        usersRepository.saveAndFlush(new Users("new jeong", "jeong2@naver.com"));
//        usersRepository.findAll().forEach(System.out::println);

        // 9. count
//        long count = usersRepository.count();
//        System.out.println(count);

        // 10. existsById  : count 쿼리를 사용하여 exists 확인
//        boolean exists = usersRepository.existsById(1L);
//        System.out.println(exists);

        // 11. delete / deleteById
//        usersRepository.delete(usersRepository.findById(2L).orElse(null));
//        usersRepository.delete(usersRepository.findById(1L).orElseThrow(RuntimeException::new));
//        usersRepository.findAll().forEach(System.out::println);
//
//        usersRepository.deleteById(3L);
//        usersRepository.findAll().forEach(System.out::println);

        // 12. deleteAll  : 이터러블로 하나씩 지움
//        usersRepository.deleteAll();  // 1) 데이터 하나하나씩 delete 쿼리 들어감
//        usersRepository.deleteAll(usersRepository.findAllById(Lists.newArrayList(1L, 3L)));
//        // 2) 각각 ENTITY가 존재하는지 ID별 SELECT 후 DELETE 진행 (성능이슈 발생 가능)
//        usersRepository.findAll().forEach(System.out::println);

        // 13. deleteInBatch  : 쿼리 한번으로 다 지움
//        usersRepository.deleteInBatch(usersRepository.findAllById(Lists.newArrayList(1L, 3L)));
//        // 1) select가 없고 delete가 한번만 사용  // findAllById로 select문 수행
//        usersRepository.deleteAllInBatch();  // 2) 한번에 다 삭제
//        usersRepository.findAll().forEach(System.out::println);

        // 14. page : type을 Page로 사용하기 위해 pageable 처리 : PageRequest는 pageable의 구현체
//        Page<Users> users = usersRepository.findAll(PageRequest.of(1,3));  // page 0에는 3개 page 1에는 2개
//
//        System.out.println("page: " + users);
//        System.out.println("totalElements: " + users.getTotalElements());  // insert 5개 해서 5개
//        System.out.println("totalPages: " + users.getTotalPages());  // PageRequest의 size 3 이여서 5/3 = 2page
//        System.out.println("numberOfElements: " + users.getNumberOfElements()); // 1page : 3개 / 2page : 2개 (우리가 가져온거 2페이지)
//        // 왜 2 page?  페이지는 0부터 시작함
//        System.out.println("sort: " + users.getSort());  // sort 적용 안함
//        System.out.println("size: " + users.getSize());
//
//        users.getContent().forEach(System.out::println);

        // 15. Example (QueryByExample / QueryMatcher 검색) : 검색이 필요한 것을 Example을 이용하여 쿼리 생성
        // 1)
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")  // matching에서 무시
//                .withMatcher("email", endsWith());  // email은 match해야 함 , endsWith() : 뒤쪽이 맞으면 됨
//
//        Example<Users> example = Example.of(new Users("ma","naver.com"),matcher);
        // new Users("ma","naver.com")에 이름도 NonNull이여서 넣었으나. email만 matcher하기 때문에 naver.com 있는것 조회(where like)

        // 2) 이름과 메일 다 match하게 검색
//        Example<Users> example = Example.of(new Users("jeong","jeong@naver.com"));

        // 3)
        Users users = new Users();
        users.setEmail("gmail");

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());  // email은 match해야 함, contains() : 양방향
        Example<Users> example = Example.of(users, matcher);

        usersRepository.findAll(example).forEach(System.out::println);

    }

}