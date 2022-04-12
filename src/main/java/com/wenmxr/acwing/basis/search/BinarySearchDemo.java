package com.wenmxr.acwing.basis.search;

/**
 * 整数二分
 *
 * @Author qinwen
 * @Date 2022/4/1 8:39 上午
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 2, 2, 2, 2, 2, 5, 6, 6};
        System.out.println(binarySearch1(nums, 2));
        System.out.println(binarySearch1(nums, 1));
        System.out.println(binarySearch1(nums, 3));
        System.out.println(binarySearch1(nums, 10));

        System.out.println(binarySearch2(nums, 2));
        System.out.println(binarySearch2(nums, 1));
        System.out.println(binarySearch2(nums, 3));
        System.out.println(binarySearch2(nums, 10));
    }

    public static int binarySearch1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        // 递增序列 从左往右找 找到第一个num[l] >= target 的位置
        System.out.print("L：" + l + " ");
        if (nums[l] == target) {
            return l;
        }
        return -1;
    }

    public static int binarySearch2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        // 递增序列 从右往左找 找第一个 nums[l] <= target 的位置
        System.out.print("L：" + l + " ");
        if (nums[l] == target) {
            return l;
        }
        return -1;
    }


}


