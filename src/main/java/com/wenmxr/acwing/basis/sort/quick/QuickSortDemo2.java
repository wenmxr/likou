package com.wenmxr.acwing.basis.sort.quick;

import java.util.Arrays;

/**
 * @Author qinwen
 * @Date 2022/3/28 6:21 下午
 */
public class QuickSortDemo2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 3, 4, 3, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 随机找一个数 数组第一个
        int x = arr[l];
        // 定义左指针 右指针
        int i = l - 1, j = r + 1;
        while (i < j) {
            // 找到比左指针大的位置
            while (arr[++i] < x) {}
            // 找到比右指针大的位置
            while (arr[--j] > x) {}
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        // 递归左半边
        quickSort(arr, l, j);
        // 递归右半边
        quickSort(arr, j + 1, r);
    }
}
