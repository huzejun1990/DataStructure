package com.dream.spring.circulardepend.construnctorinjection;

import org.springframework.stereotype.Component;

/**
 * @Author: huzejun
 * @Date: 2020/12/7 16:59
 */
@Component
public class ServiceA {

    private ServiceB serviceB;

    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}
