package com.dream.spring.circulardepend.setinjection;

import org.springframework.stereotype.Component;

/**
 * @Author: huzejun
 * @Date: 2020/12/7 17:06
 */
@Component
public class ServiceBB {

    private ServiceAA serviceAA;

    public void setServiceAA(ServiceAA serviceAA) {
        this.serviceAA = serviceAA;
        System.out.println("B 里面设置了 A");
    }
}
