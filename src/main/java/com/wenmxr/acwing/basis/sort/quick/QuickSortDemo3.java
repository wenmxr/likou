package com.wenmxr.acwing.basis.sort.quick;

import java.util.Arrays;

/**
 * @Author qinwen
 * @Date 2022/4/7 8:57 上午
 */
public class QuickSortDemo3 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 5, -1, 5, 2};
        quickSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int l, int r, int[] arr) {
        if (l >= r) {
            return;
        }
        // 定义左右指针
        int i = l - 1, j = r + 1;
        int x = arr[l];
        // i == j or i = j + 1 结束 ==> i >= j
        while (i < j) { // =?
            while (arr[++i] < x) {
            }
            ;
            while (arr[--j] > x) {
            }
            ;
            if (i < j) {// =?
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        quickSort(l, j, arr);
        quickSort(j + 1, r, arr);
    }
}
