package com.wenmxr.algorithm;

/**
 * 27.移除元素
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @Author qinwen
 * @Date 2021/11/8 12:19 上午
 */
public class RemoveElement {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement2(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    /**
     * 快慢双指针
     *
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ans++] = nums[i];
            }
        }
        return ans;
    }

    /**
     * 暴力求解法
     * 删除数据中的元素 向前覆盖
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        // [0,1,2,2,3,0,4,2]
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                int a = i;
                for (int j = i + 1; j < size; j++) {
                    nums[a++] = nums[j];
                }
                size--;
                i--;
            }
        }
        return size;
    }
}
