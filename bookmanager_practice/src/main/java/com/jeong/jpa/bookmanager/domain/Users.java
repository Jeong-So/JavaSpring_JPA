package com.jeong.jpa.bookmanager.domain;

import com.jeong.jpa.bookmanager.domain.listener.Auditable;
import com.jeong.jpa.bookmanager.domain.listener.UsersEntityListener;
import lombok.*;

import javax.persistence.*;

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
@Table(name = "users", indexes= { @Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
// INDEX나 constraints는 실제 DB에 적용된 것과 다를 수 있음, jpa entity를 활용하여 DDL을 생성하는 경우는 적용잉 되지만
// 일반적으로 많이 사용하는 crud쿼리를 사용할 때는 아무런 효력 없음
// 실제 DB에 INDEX가 없는데 JPA에 설정한다고 해서 DB에 반영되는건 아님
public class Users extends BaseEntity implements Auditable {
    @Id  // pk값
    @GeneratedValue  // 자동으로 증가
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)  // Enum의 타입이 default로 ORDINAL로 되어있으나 값이 틀어질 수 있기 때문에 String으로 바꿔줘야함
    private Gender gender;


    @Transient  // 영속성 처리 제외 : 해당 객체와 생명주기를 같이함 (DB에 반영하지 않고 그냥 사용하고 싶은 Object 속성), DDL시 반영 안됨
    private String testData;

    private boolean allow;

}
