package com.wenmxr.acwing.basis.doublepointer;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 双指针——最长连续不重复子序列
 * https://www.acwing.com/problem/content/description/801/
 *
 * @Author qinwen
 * @Date 2022/5/18 7:05 上午
 */
public class SubSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();

        // 原数组
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 频率标记数组
        int[] s = new int[n + 1];
        int ans = 0;

        // 维护一个区间
        for (int i = 0, j = 0; i < n; i++) {
            // 向右扩展区间右端点
            s[arr[i]]++;
            // 当向右扩展右端点后，j-i区间元素可能重复，下面while循环用来去重，通过收缩左端点来去重
            while (j < i && s[arr[i]] > 1) {
                // 区间数量减一，左端点右移
                s[arr[j++]]--;
            }
            ans = Math.max(ans, i - j + 1);
        }

        System.out.println(ans);
    }
}
