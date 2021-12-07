package com.wenmxr.algorithm;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 20.有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @Author qinwen
 * @Date 2021/8/26 8:47 上午
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid1("([{}])"));
        System.out.println(isValid2("([{}])"));
        System.out.println(isValid3("(("));
    }

    public static boolean isValid1(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return s.isEmpty();
    }

    public static boolean isValid2(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        for (int i = 0; i < length / 2; i++) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return s.isEmpty();
    }


    public static boolean isValid3(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        HashMap<Character, Character> hashTable = new HashMap<>(3);
        hashTable.put(')', '(');
        hashTable.put(']', '[');
        hashTable.put('}', '{');

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (hashTable.containsKey(c)) {
                if (stack.isEmpty() || !hashTable.get(c).equals(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
