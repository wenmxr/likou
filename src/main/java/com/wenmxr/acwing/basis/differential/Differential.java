package com.wenmxr.acwing.basis.differential;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 差分
 * https://www.acwing.com/problem/content/799/
 *
 * 差分初始化：b[i] = a[i] - a[i - 1]
 *
 * @Author qinwen
 * @Date 2022/5/12 10:50 上午
 */
public class Differential {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n + 10];
        // 差分数组
        int[] b = new int[n + 10];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            // 差分数组初始化
            b[i] = a[i] - a[i - 1];
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        while (m-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            b[l] += c;
            b[r + 1] -= c;
            System.out.println(Arrays.toString(b));
        }

        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + b[i];
            System.out.print(a[i] + " ");
        }
    }
}
