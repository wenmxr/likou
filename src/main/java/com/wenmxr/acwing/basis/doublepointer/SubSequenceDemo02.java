package com.wenmxr.acwing.basis.doublepointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author qinwen
 * @Date 2022/6/10 2:54 下午
 */
public class SubSequenceDemo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Map<Integer, Integer> map = new HashMap();
        int ans = 0;

        for (int i = 0, j = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                j = Math.max(j, map.get(arr[i]) + 1);
            }
            map.put(arr[i], i);
            ans = Math.max(ans, i - j + 1);
        }

        System.out.println(ans);

    }
}
