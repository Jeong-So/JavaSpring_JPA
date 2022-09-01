package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.Gender;
import com.jeong.jpa.bookmanager.domain.Users;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

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
//        // 1.
//        System.out.println(usersRepository.findByName("jeong"));
//
//        // 2. findBy / getBy / readBy / queryBy / searchBy / streamBy / find...By / findSomethingBy  : 다 같은 select 쿼리
//        System.out.println("findByEmail : " + usersRepository.findByEmail("jeong@naver.com"));
//        System.out.println("getByEmail : " + usersRepository.getByEmail("jeong@naver.com"));
//        System.out.println("readByEmail : " + usersRepository.readByEmail("jeong@naver.com"));
//        System.out.println("queryByEmail : " + usersRepository.queryByEmail("jeong@naver.com"));
//        System.out.println("searchByEmail : " + usersRepository.searchByEmail("jeong@naver.com"));
//        System.out.println("streamByEmail : " + usersRepository.streamByEmail("jeong@naver.com"));
//        System.out.println("findUserByEmail : " + usersRepository.findUserByEmail("jeong@naver.com"));
//
//        System.out.println("findSomethingByEmail : " + usersRepository.findSomethingByEmail("jeong@naver.com"));
//
//        // 3. findFirst[number]By = findTop[number]By
//        System.out.println("findTop2ByName : " + usersRepository.findTop2ByName("jeong"));
//        System.out.println("findFirst2ByName : " + usersRepository.findFirst2ByName("jeong"));
//        System.out.println("findLast1ByName : " + usersRepository.findLast1ByName("jeong"));
//
//        // 4. AND OR
//        System.out.println("findByEmailAndName : " + usersRepository.findByEmailAndName("jeong@naver.com", "jeong"));
//        System.out.println("findByEmailOrName : " + usersRepository.findByEmailOrName("jeong@naver.com", "dennis"));
//
//        //5. 비교 (Between / GreaterThanEqual/ After, Before / GreaterThanEqualAndIdLessThanEqual)
//        System.out.println("findByCreatedAtAfter : " + usersRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByIdAfter : " + usersRepository.findByIdAfter(4L));
//        System.out.println("findByCreatedAtGreaterThan : " + usersRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtGreaterThanEqual : " + usersRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtBetween : " + usersRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
//        System.out.println("findByIdBetween : " + usersRepository.findByIdBetween(1L, 3L));
//        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + usersRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));
//
//        // 6. IsNotNull / IsNotEmpty : 파라미터 안받음 (해당값 상수처럼 사용됨)
//        System.out.println("findByIdIsNotNull : " + usersRepository.findByIdIsNotNull());
//        System.out.println("findByIdIsNotEmpty : " + usersRepository.findByAddressIsNotEmpty()); // exists inner 쿼리
//
//        // True/False : boolean타입 컬럼의 True Talse 검색, IsNotNull / IsNotEmpty 처럼 파라미터 안받음 (해당값 상수처럼 사용됨)
//        System.out.println("findByAllowTrue : " + usersRepository.findByAllowTrue());
//        System.out.println("findByAllowFalse : " + usersRepository.findByAllowFalse());
//
//        // 7. In 쿼리 = OR 조건과 유사
        System.out.println("findByNameIn : " + usersRepository.findByNameIn(Lists.newArrayList("jeong", "dennis")));

        // 8. Like 쿼리 (StartingWith : 앞부분이 맞는 것 / EndingWith : 뒷부분이 맞는 것 / Contains : 포함된 것
        System.out.println("findByNameStartingWith : " + usersRepository.findByNameStartingWith("jeo")); // jeo%
        System.out.println("findByNameEndingWith : " + usersRepository.findByNameEndingWith("ong"));  // %ong
        System.out.println("findByNameContains : " + usersRepository.findByNameContains("eon"));  // %eon%

        System.out.println("findByNameLike : " + usersRepository.findByNameLike("%eon%"));
    }

    @Test
    void pagingAndSortingTest() {
        // 9. sorting(OrderBy Desc/Asc)
        System.out.println("findTop1ByName : " + usersRepository.findTop1ByName("jeong"));
        System.out.println("findTopByNameOrderByIdDesc : " + usersRepository.findTopByNameOrderByIdDesc("jeong"));
        System.out.println("findFirst2ByNameOrderByIdDescEmailAsc : " + usersRepository.findFirst2ByNameOrderByIdDescEmailAsc("jeong"));
        // sort 조건을 따로 줌 (why? : 메소드 이름이 너무 길어져서)
        System.out.println("findFirstByNameWithSortParams : " + usersRepository.findFirstByName("jeong", Sort.by(Order.desc("id"), Order.asc("email"))));
        System.out.println("findFirstByNameWithSortParams : " + usersRepository.findFirstByName("jeong", getSort()));


        // 10. paging
        System.out.println("findByNameWithPaging : " + usersRepository.findByName("jeong", PageRequest.of(1, 1, Sort.by(Order.desc("id")))).getContent());
        // getTotalElement() : dennis란 이름이 insert 1번됨 / jeong이란 이름이 insert 3번 됨
    }

    private Sort getSort(){
        return Sort.by(
                Order.desc("id"),
                Order.asc("email"),
                Order.desc("createdAt"),
                Order.asc("updatedAt")
        );
    }

    @Test
    void insertAndUpdateTest() {
        Users users = new Users();
        users.setName("yeong");
        users.setEmail("yeong@gmail.com");

        usersRepository.save(users);

        Users users2 = usersRepository.findById(1L).orElseThrow(RuntimeException::new);
        users2.setName("jjjeong");

        usersRepository.save(users2);

        usersRepository.findAll().forEach(System.out::println);

    }

    @Test
    void enumTest(){
        Users users = usersRepository.findById(1L).orElseThrow(RuntimeException::new);
        users.setGender(Gender.MALE);

        usersRepository.save(users);

        usersRepository.findAll().forEach(System.out::println);

        System.out.println(usersRepository.findRawRecord().get("gender"));
    }

    @Test
    void listenerTest(){
        Users users = new Users();
        users.setEmail("yujeong@kt.com");
        users.setName("yujeong");

        usersRepository.save(users);  // insert

        Users users2 = usersRepository.findById(1L).orElseThrow(RuntimeException::new);
        users2.setName("jjjeong");

        usersRepository.save(users2);  // update

        usersRepository.deleteById(4L);
    }

    @Test
    void prePersistTest() {
        Users user = new Users();
        user.setEmail("moon@naver.com");
        user.setName("moon");
//        user.setCreatedAt(LocalDateTime.now());  // 개발자가 insert때마다 넣는 것은 비효율적이고 누락 시 치명적
//        user.setUpdatedAt(LocalDateTime.now());  // CreatedAt / UpdatedAt 같은 것은 아예 insert 전 prepersist 설정해서 자동으로 set하도록 설정

        usersRepository.save(user);

        System.out.println(usersRepository.findByEmail("moon@naver.com"));
    }

    @Test
    void preUpdateTest() {
        Users user = usersRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("jjjeong");
        usersRepository.save(user);

        System.out.println("to-be : " + usersRepository.findAll().get(0));
    }


}
