package com.jeong.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity  //  ORM : db tabel 과 자바 객체(Entity) 간의 연결을 만들어 주는 것  @Entity : 객체를 Entity로 선언해 주는 어노테이션, Entity에는 PK가 반드시 필요
public class Users {
    @Id  // pk값
    @GeneratedValue  // 자동으로 증가
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
