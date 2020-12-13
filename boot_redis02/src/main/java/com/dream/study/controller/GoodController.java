package com.dream.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: huzejun
 * @Date: 2020/12/12 16:11
 */
@RestController
public class GoodController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${server.port}")
    private String serverPort;

    private final Lock lock = new ReentrantLock();

    @GetMapping("/buy_goods")
    public String buy_Goods() {
        synchronized (this) {
            String result = stringRedisTemplate.opsForValue().get("goods:001");// get key == 看看库存的数量够不够
            int goodNumber = result == null ? 0 : Integer.parseInt(result);

            if (goodNumber > 0) {
                int realNumber = goodNumber - 1;
                stringRedisTemplate.opsForValue().set("goods:001", String.valueOf(realNumber));
                System.out.println("成功买到商品，库存还剩下：" + realNumber + "件" + "\t 服务提供端口 " + serverPort);

                return "成功买到商品，库存还剩下：" + realNumber + "件" + "\t 服务提供端口 " + serverPort;

            } else {
                System.out.println("商品已经售完/活动结束/调用超时，欢迎下次光临" + "\t 服务提供端口 " + serverPort);

            }
            return "商品已经售完/活动结束/调用超时，欢迎下次光临" + "\t 服务提供端口 " + serverPort;
        }

        //我等着觉得时间太长了，我想放弃等待。
        //给我一个规定的时间内，拿不到锁我再放弃
    }


}
