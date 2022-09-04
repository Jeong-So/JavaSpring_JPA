package com.jeong.jpa.bookmanager.domain;

import com.jeong.jpa.bookmanager.domain.listener.Auditable;
import com.jeong.jpa.bookmanager.domain.listener.UsersEntityListener;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(callSuper = true) // 상속받은 클래스 정보 처리를 위한 어노테이션 재정의
@EqualsAndHashCode(callSuper = true) // 상속받은 클래스 정보 처리를 위한 어노테이션 재정의
// 상속받은 클래스까지 toString을 하고 Equals와 HashCode를 비교하겠다는 뜻
@Builder
@Entity  //  ORM : db table 과 자바 객체(Entity) 간의 연결을 만들어 주는 것  @Entity : 객체를 Entity로 선언해 주는 어노테이션, Entity에는 PK가 반드시 필요, 해당 객체가 jpa에서 관리하는 Entity임 정의
@EntityListeners(value = UsersEntityListener.class)
public class Users extends BaseEntity {
    @Id  // pk값
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동으로 증가
    private Long id;
    // hibernate_sequence로 자동으로 증가시키는 전략(모든 테이블 동시에)을 IDENTITY호 바꿔서 객체(tABLE)마다 자동증가로 바꿔줌

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)  // Enum의 타입이 default로 ORDINAL로 되어있으나 값이 틀어질 수 있기 때문에 String으로 바꿔줘야함
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id") // , insertable = false, updatable = false
    // @JoinColumn : 중간 mapping 테이블 제거를 위해 사용, 엔티티가 어떤 컬럼으로 조인을 하게 될지 지정해주는 어노테이션
    // users_history 테이블에 users_histories_id라는 join 컬럼 생성 --> name 지정 (user_id)
    // insertable = false, updatable = false : User 엔티티에서는 usersHistories 값을 저장/수정 불가하게 설정
    @ToString.Exclude
    @Builder.Default
    private List<UsersHistory> usersHistories = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "users_id")
    @ToString.Exclude
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();

}
