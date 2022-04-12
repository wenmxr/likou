package com.wenmxr.acwing.basis.sort.merge;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 归并排序
 *
 * @Author qinwen
 * @Date 2022/3/28 6:40 下午
 */
public class MergeSortDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        // 获取数组长度 分配内存空间
        int n = scanner.nextInt();
        // 为数组赋值
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = scanner.nextInt();
        }
        // 快排
        mergeSort(q, 0, n - 1);
        System.out.println(Arrays.toString(q));
    }

    /**
     * <ol>
     *     <li>确定二分点</li>
     *     <li>递归左右两边</li>
     *     <li>合二为一</li>
     * </ol>
     * @param q 原始数组
     * @param l
     * @param r
     */
    private static void mergeSort(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }
        // 1、确定二分点
        int mid = l + r >> 1;
        // 2、递归左右两边
        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);
        // 3、归并
        // i指针 指向左半段第一个位置 j指针指向右半段第一个位置
        int[] tmp = new int[r - l + 1];
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            // 找到较小的数 放到tmp数组中
            if (q[i] <= q[j]) {
                tmp[k++] = q[i++];
            } else {
                tmp[k++] = q[j++];
            }
        }


        while (i <= mid) {
            tmp[k++] = q[i++];
        }
        while (j <= r) {
            tmp[k++] = q[j++];
        }

        for(i = l, j = 0; i <= r; i++, j++) {
            q[i] = tmp[j];
        }
    }
}
