package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Repository : 해당 객체 생성 및 조회
// JpaRepository<Entity타입, Entity의 Pk값>
public interface UsersRepository extends JpaRepository<Users, Long> {

    // 1.
//    Users findByName(String name); // 데이터 2개이상이면 오류 발생
//    List<Users> findByName(String name);
//    Optional<Users> findByName(String name);  // 데이터 2개이상이면 오류 발생
    Set<Users> findByName(String name);
    // findUserByNameIs = findUserByName = findUserByNameEquals  ; 동일한 코드, 가독성 있게 만든 것
    Set<Users> findUserByNameIs(String name);
    Set<Users> findUserByName(String name);
    Set<Users> findUserByNameEquals(String name);

    // 2. findBy / getBy / readBy / queryBy / searchBy / streamBy / find...By / findSomethingBy  : 다 같은 select 쿼리
    Users findByEmail(String email);
    Users getByEmail(String email);
    Users readByEmail(String email);
    Users queryByEmail(String email);
    Users searchByEmail(String email);
    Users streamByEmail(String email);
    Users findUserByEmail(String email);
    Users findSomethingByEmail(String email);

    // 3. findFirst[number]By = findTop[number]By
    List<Users> findFirst2ByName(String name);
    List<Users> findTop2ByName(String name);
    // findLast1ByName : Last1은 의미 X   findByName 과 같음
    List<Users> findLast1ByName(String name);

    // 4. AND OR
    List<Users> findByEmailAndName(String email, String name);
    List<Users> findByEmailOrName(String email, String name);

    //5. 비교 (Between / GreaterThanEqual/ After, Before / GreaterThanEqualAndIdLessThanEqual)
    List<Users> findByCreatedAtAfter(LocalDateTime yesterday);
    List<Users> findByIdAfter(Long id);
    List<Users> findByCreatedAtGreaterThan(LocalDateTime yesterday);
    List<Users> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);
    List<Users> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);
    List<Users> findByIdBetween(Long id1, Long id2);
    List<Users> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    // 6. IsNotNull / IsNotEmpty
    List<Users> findByIdIsNotNull();
//    List<Users> findByAddressIsNotEmpty();   // name is not null and name != '' 의 의미는 아님
    // String에서의 Empty와 다름, 일반적으로 NotNull이면서 NotEmpty 체크
    // IsEmpty와 IsNotEmpty는 collection properites에서만 사용가능 --> Collection Type의 NotEmpty 체크 (relation에서 이해가능)
    // exists inner 쿼리

    // True/False : boolean타입 컬럼의 True Talse 검색,  IsNotNull / IsNotEmpty 처럼 파라미터 안받음 (해당값 상수처럼 사용됨)
//    List<Users> findByAllowTrue();
//    List<Users> findByAllowFalse();

    // 7. In 쿼리 = OR 조건과 유사
    List<Users> findByNameIn(List<String> names);

    // 8. Like 쿼리 (StartingWith : 앞부분이 맞는 것 / EndingWith : 뒷부분이 맞는 것 / Contains : 포함된 것
    List<Users> findByNameStartingWith(String name);
    List<Users> findByNameEndingWith(String name);
    List<Users> findByNameContains(String name);
    List<Users> findByNameLike(String name);

    // 9. sorting(OrderBy Desc/Asc)
    List<Users> findTop1ByName(String name);
    List<Users> findTopByNameOrderByIdDesc(String name);
    List<Users> findFirst2ByNameOrderByIdDescEmailAsc(String name);
    // sort조건 따로 줌
    List<Users> findFirstByName(String name, Sort sort);

    // 10. paging ; return 타입으로 받고 있는 Page 인터페이스
    Page<Users> findByName(String name, Pageable pageable);

    // 11. enum 사용법
    @Query(value = "select * from users limit 1;", nativeQuery = true)  // nativeQuery = true : 이 쿼리 그대로 실행
    Map<String, Object> findRawRecord();
}
