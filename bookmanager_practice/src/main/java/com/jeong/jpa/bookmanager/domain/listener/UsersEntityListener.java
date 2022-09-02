package com.jeong.jpa.bookmanager.domain.listener;

import com.jeong.jpa.bookmanager.domain.Users;
import com.jeong.jpa.bookmanager.domain.UsersHistory;
import com.jeong.jpa.bookmanager.repository.UsersHistoryRepository;
import com.jeong.jpa.bookmanager.support.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UsersEntityListener {
    @PostPersist
    @PostUpdate
    public void prePersistAndPreUpdate(Object o) {
        UsersHistoryRepository usersHistoryRepository = BeanUtils.getBean(UsersHistoryRepository.class);


        Users user = (Users) o;

        UsersHistory userHistory = new UsersHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        usersHistoryRepository.save(userHistory);
    }
}
