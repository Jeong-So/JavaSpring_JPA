package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.BookReviewInfo;
import com.jeong.jpa.bookmanager.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
