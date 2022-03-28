package com.wenmxr.acwing.basis;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author qinwen
 * @Date 2022/3/25 6:18 下午
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        // 获取数组长度 分配内存空间
        int n = scanner.nextInt();
        int q[] = new int[n];
        // 为数组赋值
        for (int i = 0; i < n; i++) {
            q[i] = scanner.nextInt();
        }
        // 快排
        quickSort(q, 0, n - 1);
        System.out.println(Arrays.toString(q));
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 定义左指针 右指针
        int i = l - 1, j = r + 1;
        // 任意取一个哨兵 首位、末位、中间位
        int x = arr[l];
        while (i < j) {
           // 找到左边第一个大于哨兵的位置
           while (arr[++i] < x) {}
           // 找到右边第一个小于哨兵的位置
           while (arr[--j] > x) {}
           // 交换数据
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        // 左边递归
        quickSort(arr, l, j);
        // 右边递归
        quickSort(arr, j + 1, r);
    }
}
