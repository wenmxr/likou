package com.wenmxr.acwing.basis.search;

/**
 * @Author qinwen
 * @Date 2022/4/7 8:32 上午
 */
public class BinarySearchDemo2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 3, 3, 4, 4, 5, 6};
        System.out.println(binarySearch01(arr, 3));
        System.out.println(binarySearch02(arr, 3));
    }

    private static int binarySearch02(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (arr[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
            if (arr[l] == target) {
                return l;
            }
        }
        return -1;
    }

    private static int binarySearch01(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (arr[l] == target) {
            return l;
        }
        return -1;
    }
}
