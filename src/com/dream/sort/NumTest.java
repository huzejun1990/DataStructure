package com.dream.sort;

import org.junit.Test;

import java.util.Random;

/**
 * Created by huzejun
 * on 2020/10/20 11:24
 */

/**
 * 整型数组data[]中每个元素的取值范围是[0,99999],编写Java程序统计在每个长度为10的区间各个有多少个数字:
 * [0,9],[10,19],...[99990,99999]
 */
public class NumTest {

    private Random random = new Random();

    @Test
    public void test(){
        int[] data = createDate();
        dataCount(data);
    }


    private int[] createDate() {
        Integer num = random.nextInt(100000);
        int[] datas = new int[num];
        for (int i = 0; i < datas.length; i++) {
            datas[i] = random.nextInt(100000);
        }
        return datas;
    }

    private void dataCount(int[] datas) {
        int[] countArray = new int[10000];
        for (int i = 0; i < datas.length; i++) {
            int index = datas[i] / 10;
            countArray[index] += 1;
        }
        //打印统计
        for (int i = 0; i < countArray.length; i++) {
            System.out.println("第"+i+"个区间："+countArray[i]+"个");
        }
    }
}
