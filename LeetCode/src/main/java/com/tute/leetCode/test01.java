package com.tute.leetCode;

import java.util.HashMap;

/**
 * 两数之和问题 LeetCode 第一题
 */
public class test01 {



    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];

        //创建k-v，一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            //将数据存入key为补数，value为下标
            hash.put(target - nums[i], i);
        }
        return indexs;
    }


    /**
     * 暴力破解
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum01(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}
