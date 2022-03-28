package com.wenmxr.algorithm.array;

import java.util.Arrays;

/**
 * 977.有序数组的平方
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *
 * @Author qinwen
 * @Date 2021/11/9 12:04 上午
 */
public class SquaresOfaSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares2(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares3(new int[]{-4, -1, 0, 3, 10})));
    }

    /**
     * 选择排序 O(n*2)
     * @param A
     * @return
     */
    public static int[] sortedSquares(int[] A) {
        int[] b = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            b[i] = A[i] * A[i];
        }
        for (int i = 0; i < b.length - 1; i++) {
            for (int j = i + 1; j < b.length; j++) {
                if (b[i] > b[j]) {
                    int temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
        return b;
    }

    /**
     * 快排 O(n * log(n)))
     * @param A
     * @return
     */
    public static int[] sortedSquares2(int[] A) {
        int[] b = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            b[i] = A[i] * A[i];
        }
        Arrays.sort(b);
        return b;
    }

    /**
     * 双指针 O(n)
     *
     * @param A
     * @return
     */
    public static int[] sortedSquares3(int[] A) {
        // 指针i => 最左端
        int i = 0;
        // 指针j => 最右端
        int j = A.length - 1;

        // 结果数组
        int[] result = new int[A.length];
        // 指针k => 结果数组最右端
        int k = result.length - 1;
        while (i <= j) {
            if (A[i] * A[i] > A[j] * A[j]) {
                result[k--] = A[i] * A[i];
                i++;
            } else {
                result[k--] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
