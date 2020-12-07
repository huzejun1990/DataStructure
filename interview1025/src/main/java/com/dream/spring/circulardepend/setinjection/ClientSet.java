package com.dream.spring.circulardepend.setinjection;

/**
 * @Author: huzejun
 * @Date: 2020/12/7 17:09
 */
public class ClientSet {

    public static void main(String[] args) {
        //创建serviceAA
        ServiceAA a = new ServiceAA();

        //创建serviceBB
        ServiceBB b = new ServiceBB();
        //将serviceA注入到serviceB中
        b.setServiceAA(a);
        //将serviceB注入到serviceA中
        a.setServiceBB(b);
    }
}
