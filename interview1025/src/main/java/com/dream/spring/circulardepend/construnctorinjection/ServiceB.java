package com.dream.spring.circulardepend.construnctorinjection;

import org.springframework.stereotype.Component;

/**
 * @Author: huzejun
 * @Date: 2020/12/7 16:58
 */
@Component
public class ServiceB {

    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
