package com.jeong.jpa.bookmanager.domain;

import com.jeong.jpa.bookmanager.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true) // 상속받은 클래스 정보 처리를 위한 어노테이션 재정의
@EqualsAndHashCode(callSuper = true) // 상속받은 클래스 정보 처리를 위한 어노테이션 재정의
// 상속받은 클래스까지 toString을 하고 Equals와 HashCode를 비교하겠다는 뜻
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private Long authorId;

//    private Long publisherId;

    @OneToOne(mappedBy = "book") // mappedBy 설정 시 연관 키를 해당 테이블에서 갖지 않게 됨 --> book 테이블에 book_review_info_id 사라짐
    @ToString.Exclude  // stackOverFlowError : Entity relation 사용 시 toString같은 메소드 순환참조 걸림 relation은 단방향으로 걸거나 toString에서 제외
    private BookReviewInfo bookReviewInfo;

    @OneToMany//(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id") // , insertable = false, updatable = false
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne
    @ToString.Exclude
    private Publisher publisher;

}
