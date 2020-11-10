package com.dream.study.javase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huzejun
 * on 2020/11/9 0:59
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target,请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应琴答案。但是，数组中同一个元素不能使用两遍
 * </p>
 * <p>
 * 给定 nums = {2,7,11,15}; target = 9;
 * </p>
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9;
 * </p>
 * 所以返回 【0，1】
 */
public class TwoSumDemo {

    // 遍历 --> 暴力破解

    /**
     * 通过双重循环遍历数组中所有元素的两两组合，当出现符合的和时返回两个元素的下标
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int partenerNumber = target - nums[i];
            if (map.containsKey(partenerNumber)){
                return new int[]{map.get(partenerNumber),i};
            }
            map.put(nums[i],i);
        }

        //map  k值  v下标
        //     2    i
        return null;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] myIndex = twoSum2(nums,target);

        for (int element : myIndex) {
            System.out.println(element);
        }
    }
}
