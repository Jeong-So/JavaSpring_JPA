package com.jeong.jpa.bookmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

// IsNotEmpty() 실습
@Entity
public class Address {
    @Id
    private Long id;
}
