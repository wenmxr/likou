package com.wenmxr.acwing.basis.prefixand;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 前缀和
 * https://www.acwing.com/problem/content/797/
 *
 * 前缀和：S[i] = S[i - 1] + a[i]
 * 注意：前缀和下标从1开始
 *
 * @Author qinwen
 * @Date 2022/5/15 1:52 下午
 */
public class ThePreAnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 原数组
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] s = new int[n + 1];
        // 前缀和初始化
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + a[i];
        }

        while (m-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            // 区间和计算
            System.out.println(s[r] - s[l - 1]);
        }
    }
}
