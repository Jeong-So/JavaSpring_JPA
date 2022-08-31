package com.jeong.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity  //  ORM : db tabel 과 자바 객체(Entity) 간의 연결을 만들어 주는 것  @Entity : 객체를 Entity로 선언해 주는 어노테이션, Entity에는 PK가 반드시 필요, 해당 객체가 jpa에서 관리하는 Entity임 정의
@Table(name = "users", indexes= { @Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
// INDEX나 constraints는 실제 DB에 적용된 것과 다를 수 있음, jpa entity를 활용하여 DDL을 생성하는 경우는 적용잉 되지만
// 일반적으로 많이 사용하는 crud쿼리를 사용할 때는 아무런 효력 없음
// 실제 DB에 INDEX가 없는데 JPA에 설정한다고 해서 DB에 반영되는건 아님
public class Users {
    @Id  // pk값
    @GeneratedValue  // 자동으로 증가
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)  // Enum의 타입이 default로 ORDINAL로 되어있으나 값이 틀어질 수 있기 때문에 String으로 바꿔줘야함
    private Gender gender;

    @Column(updatable = false)  // (updatable = false) : update 유무나  (insertable = false) insert 유무 설정
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Transient  // 영속성 처리 제외 : 해당 객체와 생명주기를 같이함 (DB에 반영하지 않고 그냥 사용하고 싶은 Object 속성), DDL시 반영 안됨
    private String testData;

    private boolean allow;

//    // IsNotEmpty() 실습
//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

}
