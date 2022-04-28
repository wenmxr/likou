package com.wenmxr.algorithm.array;

import java.util.Arrays;

/**
 * @Author qinwen
 * @Date 2022/4/26 7:29 上午
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, 6)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums.length == 0) {
            return ans;
        }
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = l + r >> 1;
            if(nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if(nums[l] != target) {
            return ans;
        } else {
            ans[0] = l;
        }
        l = 0;
        r = nums.length - 1;
        while(l < r) {
            int mid = l + r + 1 >> 1;
            if(nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        ans[1] = l;
        return ans;
    }
}
