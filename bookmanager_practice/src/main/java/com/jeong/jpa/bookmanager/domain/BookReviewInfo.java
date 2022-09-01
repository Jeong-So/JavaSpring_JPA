package com.jeong.jpa.bookmanager.domain;

import com.jeong.jpa.bookmanager.domain.BaseEntity;
import com.jeong.jpa.bookmanager.domain.Book;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true) // 상속받은 클래스 정보 처리를 위한 어노테이션 재정의
@EqualsAndHashCode(callSuper = true) // 상속받은 클래스 정보 처리를 위한 어노테이션 재정의
public class BookReviewInfo  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long bookId;

    @OneToOne(optional = false)
    // 1대 1 연관관계 맵핑, (optional = false) : 반드시 존재하는 값 (left outer join --> inner join )
    private Book book;  // 엔티티 직접 참조

    private float averageReviewScore;

    private int reviewCount;
}
