package com.dream.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author: huzejun
 * @Date: 2020/12/7 11:41
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Interview1024Application {

    public static void main(String[] args) {
        SpringApplication.run(Interview1024Application.class, args);
    }
}
