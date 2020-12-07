package com.dream;

import com.dream.service.CalcService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

/**
 * @Author: huzejun
 * @Date: 2020/12/7 14:02
 */

@SpringBootTest
public class TestAop {

    @Autowired
    private CalcService service;

    @Test
    public void testAop4() {
        System.out.println("spring版本：" + SpringVersion.getVersion() + "\t" + "SpringBoot版本：" + SpringBootVersion.getVersion());

        System.out.println();

        service.div(10, 1);
    }

    @Test
    public void testAop5() {
        System.out.println("spring版本：" + SpringVersion.getVersion() + "\t" + "SpringBoot版本：" + SpringBootVersion.getVersion());

        System.out.println();

        service.div(10, 0);
    }
}