package com.wenmxr.acwing.basis.precision.add;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @Author qinwen
 * @Date 2022/4/18 5:03 下午
 */
public class AddDemo01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger(bufferedReader.readLine());
        BigInteger b = new BigInteger(bufferedReader.readLine());
        BigInteger add = a.add(b);
        System.out.println(add);

        BigInteger subtract = a.subtract(b);
        System.out.println(subtract);

        BigInteger multiply = a.multiply(b);
        System.out.println(multiply);

        BigInteger[] bigIntegers = a.divideAndRemainder(b);
        System.out.println(Arrays.toString(bigIntegers));

        BigInteger mod = a.mod(b);
        System.out.println(mod);
    }
}
