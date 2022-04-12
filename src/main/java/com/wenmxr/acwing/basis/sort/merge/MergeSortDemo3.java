package com.wenmxr.acwing.basis.sort.merge;

import java.util.Arrays;

/**
 * @Author qinwen
 * @Date 2022/4/12 5:02 下午
 */
public class MergeSortDemo3 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 1, 2, 0, 3, -1};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 1、寻找中间点
        int mid = l + r >> 1;
        // 2、递归左右两边
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        // 3、两个数组 合二为一
        int[] tmp = new int[r + 1 - l];

        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= r) {
            tmp[k++] = arr[j++];
        }

        for (i = l, j = 0; i <= r; i++, j++) {
            arr[i] = tmp[j];
        }
    }
}
