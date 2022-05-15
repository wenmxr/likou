package com.wenmxr.acwing.basis.precision.add;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 高精度加法
 *
 * @Author qinwen
 * @Date 2022/4/13 10:43 上午
 */
public class AddDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String a = scanner.nextLine();
        int[] aa = stringToArray(a);
        String b = scanner.next();
        int[] bb = stringToArray(b);

        int[] add = add(aa, bb);

        for (int i = add.length - 1; i >= 0; i--) {
            System.out.print(add[i]);
        }


    }

    private static int[] add(int[] aa, int[] bb) {
        if (aa.length < bb.length) {
            return add(bb, aa);
        }
        int[] cc = new int[aa.length + 1];
        int t = 0;
        for (int i = 0; i < aa.length; i++) {
            t += aa[i];
            if (i < bb.length) {
                t += bb[i];
            }
            cc[i] = t % 10;
            t /= 10;
        }
        int[] tmp = Arrays.copyOf(cc, cc.length - 1);

        while (tmp[tmp.length - 1] == 0) {
            tmp = Arrays.copyOf(cc, cc.length - 2);
        }
        return tmp;
    }

    private static int[] stringToArray(String a) {
        int[] arr = new int[a.length()];
        char[] charArray = a.toCharArray();
        for (int i = a.length() - 1, j = 0; i >= 0; i--) {
            arr[j++] = charArray[i] - '0';
        }
        return arr;
    }
}
