package com.jeong.jpa.bookmanager.domain;

import com.jeong.jpa.bookmanager.domain.listener.Auditable;
import com.jeong.jpa.bookmanager.domain.listener.MyEntityListener;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true) // 상속받은 클래스 정보 처리를 위한 어노테이션 재정의
@EqualsAndHashCode(callSuper = true) // 상속받은 클래스 정보 처리를 위한 어노테이션 재정의
// 상속받은 클래스까지 toString을 하고 Equals와 HashCode를 비교하겠다는 뜻
public class Book extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    // 생성/업데이트 시간 중복사항 BaseEnitiy로 만들어 상속
    /*
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    */

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
