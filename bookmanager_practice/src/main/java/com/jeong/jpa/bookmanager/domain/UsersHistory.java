package com.jeong.jpa.bookmanager.domain;

import com.jeong.jpa.bookmanager.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true) // 상속받은 클래스 정보 처리를 위한 어노테이션 재정의
@EqualsAndHashCode(callSuper = true) // 상속받은 클래스 정보 처리를 위한 어노테이션 재정의
// 상속받은 클래스까지 toString을 하고 Equals와 HashCode를 비교하겠다는 뜻
public class UsersHistory extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String name;

    private String email;

    @Transient  // 영속성 처리 제외 : 해당 객체와 생명주기를 같이함 (DB에 반영하지 않고 그냥 사용하고 싶은 Object 속성), DDL시 반영 안됨
    private String testData;

    private boolean allow;

}
