package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

// Repository : 해당 객체 생성 및 조회
// JpaRepository<Entity타입, Entity의 Pk값>
public interface UsersRepository extends JpaRepository<Users, Long> {

    // 1.
//    Users findByName(String name); // 데이터 2개이상이면 오류 발생
//    List<Users> findByName(String name);
//    Optional<Users> findByName(String name);  // 데이터 2개이상이면 오류 발생
    Set<Users> findByName(String name);

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

}
