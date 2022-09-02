package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.UsersHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersHistoryRepository extends JpaRepository<UsersHistory, Long> {
    List<UsersHistory> findByUserId(Long userId);
}
