package com.dream.study.spring.aop.impl;

import com.dream.study.spring.aop.CalcService;
import org.springframework.stereotype.Service;

/**
 * @Author: huzejun
 * @Date: 2020/12/7 16:53
 */
@Service
public class CalcServiceImpl implements CalcService {
    @Override
    public int div(int x, int y) {
        int result = x / y;
        System.out.println("=========>CalcServiceImpl被调用了,我们的计算结果：" + result);
        return result;
    }
}