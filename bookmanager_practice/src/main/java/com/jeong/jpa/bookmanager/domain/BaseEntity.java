package com.jeong.jpa.bookmanager.domain;

import com.jeong.jpa.bookmanager.domain.listener.Auditable;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// 객체마다 중복되는 생성/업데이트 시간에 대한 baseEntity 만들어서 다른 객체들이 상속 (코드 중복 방지)
@Data
@MappedSuperclass  // 해당 클래스(BaseEntity)의 field를 상속받은 Entity의 column으로 포함시키는 어노테이션
@EntityListeners(value = AuditingEntityListener.class)  // 기본리스너 설정 : MyEntityListener (직접 만듬) --> AuditingEntityListener (기본)
public class BaseEntity implements Auditable {
    @CreatedDate  // @EntityListeners에 AuditingEntityListener 주입 후 auditing으로 지정할 데이터에 설정
    private LocalDateTime createdAt;

    @LastModifiedDate // @EntityListeners에 AuditingEntityListener 주입 후 auditing으로 지정할 데이터에 설정
    private LocalDateTime updatedAt;
}
