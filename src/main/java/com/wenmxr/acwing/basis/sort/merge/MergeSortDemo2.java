package com.wenmxr.acwing.basis.sort.merge;

import java.util.Arrays;

/**
 * @Author qinwen
 * @Date 2022/3/29 11:01 上午
 */
public class MergeSortDemo2 {
    public static void main(String[] args) {
        int[] q = new int[]{3, 5, 6, 3, 1};
        mergeSort(q, 0, q.length - 1);
        System.out.println(Arrays.toString(q));
    }

    private static void mergeSort(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }
        // 1、找到二分点
        int mid = l + r >> 1;
        // 2、递归左右两边
        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);

        // 3、合二为一
        int k = 0;
        int i = l, j = mid + 1;
        int[] tmp = new int[r - l + 1];
        while (i <= mid && j <= r) {
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

        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = tmp[j];
        }
    }
}
