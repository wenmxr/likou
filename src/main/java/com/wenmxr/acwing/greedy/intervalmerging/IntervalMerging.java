package com.wenmxr.acwing.greedy.intervalmerging;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 贪心
 * 区间合并[https://www.acwing.com/problem/content/805/]
 *
 *
 * @Author qinwen
 * @Date 2022/5/20 2:23 下午
 */
public class IntervalMerging {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int[] a;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a = new int[2];
            a[0] = scanner.nextInt();
            a[1] = scanner.nextInt();
            list.add(a);
        }

        // 根据区间左端点排序
        list.sort(Comparator.comparingInt(o -> o[0]));

        System.out.println(count(list));

        System.out.println(interval(list));

    }

    /**
     * 如果需要将每个合并区间添加到一个新列表中
     * 需要记录左右端点
     *
     * @param list
     * @return
     */
    private static int interval(List<int[]> list) {
        int l = Integer.MIN_VALUE, r = Integer.MIN_VALUE;
        List<int[]> res = new ArrayList<>();
        for (int[] arr : list) {
            // 如果出现下一个区间左端点大于右端点
            if (arr[0] > r) {
                // 找到了新区间 就将老区间直接添加
                if (l != Integer.MIN_VALUE) {
                    res.add(new int[]{l, r});
                }
                l = arr[0];
                r = arr[1];
            } else {
                r = Math.max(r, arr[1]);
            }
        }

        // 最后一个区间也要加入
        if (l != Integer.MIN_VALUE) {
            res.add(new int[]{l, r});
        }
        return res.size();
    }

    /**
     *
     * 如果下一个区间左端点大于老区间右端点，则找到了新区间，数量+1,
     * 不管有没有找到新区间，每次都更新较长的右端点
     * ps：单纯计数只需维护右端点
     *
     * @param list
     * @return
     */
    private static int count(List<int[]> list) {
        int ans = 0;
        int r = Integer.MIN_VALUE;
        for (int[] arr : list) {
            if (arr[0] > r) {
                ans++;
            }
            r = Math.max(arr[1], r);
        }
        return ans;
    }
}
