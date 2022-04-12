package com.wenmxr.acwing.basis.sort.quick;

import java.util.Arrays;

/**
 * @Author qinwen
 * @Date 2022/4/12 4:50 下午
 */
public class QuickSortDemo4 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 1, 2, 0, 3, -1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l];
        // 定义左指针 找到不小于哨兵的数
        int i = l - 1;
        // 定义右指针 找到不大于哨兵的数
        int j = r + 1;
        while (i < j) {
            while (arr[++i] < x) {}
            while (arr[--j] > x) {}
            // 交换两数位置
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        quickSort(arr, l, j);
        quickSort(arr, j + 1, r);
    }


}
