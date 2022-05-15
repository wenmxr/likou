package com.wenmxr.acwing.basis.prefixand;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @Author qinwen
 * @Date 2022/5/15 2:35 下午
 */
public class ThePrefixAndDemo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n + 1];
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            s[i] = s[i - 1] + a[i];
        }
        while (m-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(s[r] - s[l - 1]);
        }
    }
}
