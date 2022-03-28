package com.wenmxr.algorithm.array;

/**
 * 704.二分查找
 * https://leetcode-cn.com/problems/binary-search/
 *
 * @Author qinwen
 * @Date 2021/10/1 9:28 下午
 */
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 13));
    }

    /**
     * 二分算法 一般有两个条件 有序 + 唯一
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
