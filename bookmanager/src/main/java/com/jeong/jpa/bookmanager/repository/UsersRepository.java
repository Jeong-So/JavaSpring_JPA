package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository : 해당 객체 생성 및 조회
// JpaRepository<Entity타입, Entity의 Pk값>
public interface UsersRepository extends JpaRepository<Users, Long> {
}
