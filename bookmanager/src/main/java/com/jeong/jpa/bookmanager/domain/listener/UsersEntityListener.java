package com.jeong.jpa.bookmanager.domain.listener;

import com.jeong.jpa.bookmanager.domain.Users;
import com.jeong.jpa.bookmanager.domain.UsersHistory;
import com.jeong.jpa.bookmanager.repository.UsersHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jeong.jpa.bookmanager.support.BeanUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

//@Component  // 1) entity Listener은 bean을 주입 받지 못함
public class UsersEntityListener {
    // 1) entity Listener은 bean을 주입 받지 못함
    /*
    @Autowired
    private UsersHistoryRepository usersHistoryRepository;
     */

    @PrePersist
    @PreUpdate
    public void prePersistAndPreUpdate(Object o) {
        // 2) BeanUtils 클래스를 통해 Bean 주입
        UsersHistoryRepository usersHistoryRepository = BeanUtils.getBean(UsersHistoryRepository.class);


        Users user = (Users) o;

        UsersHistory userHistory = new UsersHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        usersHistoryRepository.save(userHistory);
    }
}
