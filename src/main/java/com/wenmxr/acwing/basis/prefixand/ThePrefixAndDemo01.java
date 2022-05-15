package com.wenmxr.acwing.basis.prefixand;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 前缀和
 *
 * @Author qinwen
 * @Date 2022/4/28 6:15 下午
 */
public class ThePrefixAndDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] s = new int[n + 1];
        // 前缀和的初始化
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + arr[i];
        }

        while (m-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            // 区间和的计算
            System.out.println(s[r] - s[l - 1]);
        }
    }
}
