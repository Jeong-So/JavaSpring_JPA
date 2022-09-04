package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.BookReviewInfo;
import com.jeong.jpa.bookmanager.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>  {
}
