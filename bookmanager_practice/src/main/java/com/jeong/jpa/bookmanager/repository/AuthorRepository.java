package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository <Author, Long> {
}
