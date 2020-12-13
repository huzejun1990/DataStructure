package com.dream.study.controller;

import com.dream.study.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: huzejun
 * @Date: 2020/12/12 15:15
 */
@RestController
public class GoodController {

    public static final String REDIS_LOCK = "dreamLock";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/buy_goods")
    public String buy_Goods() throws Exception {

        String value = UUID.randomUUID().toString() + Thread.currentThread().getName();

        try {
            Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(REDIS_LOCK,value,10L,TimeUnit.SECONDS);
//                    .setIfAbsent(REDIS_LOCK, value);//setnx

            if (flag) {
                stringRedisTemplate.expire(REDIS_LOCK,10L, TimeUnit.SECONDS);
            }
            if (!flag) {
                return "抢锁失败，请再次重试！";
            }

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
        } finally {
/*            if (stringRedisTemplate.opsForValue().get(REDIS_LOCK).equalsIgnoreCase(value)){

                stringRedisTemplate.delete(REDIS_LOCK);
            }*/

/*         while (true){
             stringRedisTemplate.watch(REDIS_LOCK);
             if (stringRedisTemplate.opsForValue().get(REDIS_LOCK).equalsIgnoreCase(value)){
                 stringRedisTemplate.setEnableTransactionSupport(true);
                 stringRedisTemplate.multi();
                 stringRedisTemplate.delete(REDIS_LOCK);
                 List<Object> exec = stringRedisTemplate.exec();
                 if (exec == null){
                     continue;
                 }
             }
             stringRedisTemplate.unwatch();
             break;
         }*/
            Jedis jedis = RedisUtils.getJedis();

           String script = "if redis.call(\"get\",KEYS[1]) == ARGV[1]\n" +
                   "then\n" +
                   "    return redis.call(\"del\",KEYS[1])\n" +
                   "else\n" +
                   "    return 0\n" +
                   "end";
            try {
                Object o = jedis.eval(script, Collections.singletonList(REDIS_LOCK), Collections.singletonList(value));
                if ("1".equals(o.toString())){
                    System.out.println("-----del redis lock ok");
                }else {
                    System.out.println("-----del redis lock error");
                }
            }finally {
                if (null != jedis){
                    jedis.close();
                }
            }


        }
    }


}
