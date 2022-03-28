package com.wenmxr.algorithm.array;

/**
 * 209.长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * @Author qinwen
 * @Date 2021/11/11 10:04 下午
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen2(4, new int[]{1, 4, 4}));
    }

    /**
     * 暴力求解
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans > nums.length ? 0 : ans;
    }

    /**
     * 滑动窗口（快慢双指针）
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int target, int[] nums) {

        int slow = 0;
        int sum = 0;
        int quick = 0;
        int ans = nums.length + 1;
        while (quick < nums.length) {
            sum += nums[quick];
            // 当快慢指针下标和大于target 慢指针移动 窗口减小到小于target 快指针继续移动
            while (target <= sum) {
                ans = Math.min(ans, quick - slow + 1);
                sum -= nums[slow++];
            }
            quick++;
        }
        return ans > nums.length ? 0 : ans;
    }
}
