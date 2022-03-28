package com.wenmxr.algorithm.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @Author qinwen
 * @Date 2021/8/25 12:40 上午
 */
public class TwoSum {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        System.out.println(Arrays.toString(twoSum1(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(System.currentTimeMillis() - now);


    }

    /**
     * double for
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * hash table
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{hashTable.get(target - nums[i]), i};
            }
            hashTable.put(target - nums[i], i);
        }
        return new int[0];
    }
}
