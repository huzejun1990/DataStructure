package com.dream.spring.circulardepend.setinjection;

import org.springframework.stereotype.Component;

/**
 * @Author: huzejun
 * @Date: 2020/12/7 17:06
 */
@Component
public class ServiceAA {

    private ServiceBB serviceBB;

    public void setServiceBB(ServiceBB serviceBB) {
        this.serviceBB = serviceBB;
        System.out.println("A 里面设置了B");
    }
}
