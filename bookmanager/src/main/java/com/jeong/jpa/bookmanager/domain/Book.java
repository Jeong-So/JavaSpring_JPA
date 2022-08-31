package com.jeong.jpa.bookmanager.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(value = MyEntityListener.class) // MyEntityListener를 EntityListeners로 등록
@NoArgsConstructor
@Data
public class Book implements Auditable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 객체마다 중복되어 만들어야 함
    // MyEntityListener에 넣어서 모든객체가 한번에 처리 할 수 있게 함
    /*
    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
     */
}
