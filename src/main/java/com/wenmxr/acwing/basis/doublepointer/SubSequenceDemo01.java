package com.wenmxr.acwing.basis.doublepointer;

import java.util.Scanner;

/**
 * @Author qinwen
 * @Date 2022/5/23 3:10 下午
 */
public class SubSequenceDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] s = new int[100010];
        int ans = 0;

        for (int i = 0, j = 0; i < n; i++) {
            s[arr[i]]++;
            while (j < i && s[arr[i]] > 1) {
                s[arr[j++]]--;
            }
            ans = Math.max(ans, i - j + 1);
        }

        System.out.println(ans);
    }
}
