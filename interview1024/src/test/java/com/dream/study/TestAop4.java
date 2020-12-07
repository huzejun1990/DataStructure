package com.dream.study;

import com.dream.study.spring.aop.CalcService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: huzejun
 * @Date: 2020/12/7 15:10
 */
@SpringBootTest
@RunWith(SpringRunner.class)  //1.5.9
public class TestAop4 {

    @Autowired
    private CalcService service;

    @Test
    public void testAop4() {
        System.out.println("spring版本：" + SpringVersion.getVersion() + "\t" + "SpringBoot版本：" + SpringBootVersion.getVersion());

        System.out.println();

        service.div(10, 1);
    }
}