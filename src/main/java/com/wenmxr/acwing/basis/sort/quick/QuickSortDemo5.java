package com.wenmxr.acwing.basis.sort.quick;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author qinwen
 * @Date 2022/6/1 5:06 下午
 */
public class QuickSortDemo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        quickSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int l, int r) {
        // 递归出口
        if (l >= r) {
            return;
        }
        // 定义左右指针
        int i = l - 1, j = r + 1;
        // 哨兵 取任意一个位置
        int x = arr[l];

        while (i < j) {
            // 左指针找出第一个大于等于哨兵的位置
            while (arr[++i] < x) {}
            // 右指针找出第一个小于等于哨兵的位置
            while (arr[--j] > x) {}
            // 交换数据
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
