package com.hackhu;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Question55 {
    /**
     * 题：字符流中第一个不重复的字符
     * 解题思路：利用链式哈希表特性，将字符加入哈希表，再依序遍历找出第一个出现次数为 1 的字符并返回
     * @param str
     * @return
     */
    public char firstAppearingOnceChar(String str) {
        if (str == null) {
            return '\0';
        }
        HashMap<Character, Integer> hash = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (hash.containsKey(temp)) {
                hash.put(temp, hash.get(temp) + 1);
            } else {
                hash.put(temp,  1);
            }
        }
        for (Character c : hash.keySet()) {
            if (hash.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Question55 q = new Question55();
        System.out.println(q.firstAppearingOnceChar("google"));
    }
}
