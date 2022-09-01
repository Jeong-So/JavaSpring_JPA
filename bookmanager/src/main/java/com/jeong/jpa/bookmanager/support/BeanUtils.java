package com.jeong.jpa.bookmanager.support;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// entity Listener은 bean을 주입 받지 못하기 떄문에
// spring bean을 가져올 수 있는 클래스 (BeanUtils 만듬)

@Component
public class BeanUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtils.applicationContext = applicationContext;
    }

    // 해당 클래스(Class<T> clazz)에 맞는 applicationContext에서 getBean이라는 메소드를 통해서 클래스에 맞는 Bean return
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }


}
