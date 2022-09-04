package com.jeong.jpa.bookmanager.repository;

import com.jeong.jpa.bookmanager.domain.Book;
import com.jeong.jpa.bookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    void crudTest() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
//        bookReviewInfo.setBookId(1L);
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>> " + bookReviewInfoRepository.findAll());
    }

//    @Test
//    void crudTest3() {
//        Book book = new Book();
//        book.setName("Jpa 초격차 패키지");
//        book.setAuthorId(1L);
//        book.setPublisherId(1L);
//
//        bookRepository.save(book);
//
//        System.out.println(">>> " + bookRepository.findAll());
//
//        BookReviewInfo bookReviewInfo = new BookReviewInfo();
//        bookReviewInfo.setBookId(1L);
//        bookReviewInfo.setAverageReviewScore(4.5f);
//        bookReviewInfo.setReviewCount(2);
//
//        bookReviewInfoRepository.save(bookReviewInfo);
//
//        System.out.println(">>> " + bookReviewInfoRepository.findAll());
//
//        givenBookReviewInfo();
////
//        Book result = bookRepository.findById(
//                bookReviewInfoRepository
//                        .findById(1L)
//                        .orElseThrow(RuntimeException::new)
//                        .getBookId()
//                ).orElseThrow(RuntimeException::new);
//
//        System.out.println(">>> " + result);
//
//    }

    @Test
    void oneToOneRelationTest() {
        givenBookReviewInfo();

        Book result = bookReviewInfoRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBook();

        System.out.println(">>> " + result);

        BookReviewInfo result2 = bookRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBookReviewInfo();

        System.out.println(">>> " + result2);
    }

    private Book givenBook() {
        Book book = new Book();
        book.setName("Jpa 초격차 패키지");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);

        return bookRepository.save(book);
    }

    private void givenBookReviewInfo() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>> " + bookReviewInfoRepository.findAll());
    }

}