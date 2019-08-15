package com.hackhu;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Question35 {
    /**
     * 输入一个字符串，输出其第一个只出现一次的字符
     * 维护一个链式哈希，以字符为 key 出现次数为 value,每出现一次 value+1
     * 最后返回链表中第一个值为 1 的字符（key）
     * @param str
     * @return
     */
    public char firstNotRepeatChar(String str){
        if (str == null) {
            return '\0';
        }
        HashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }
        for (Character c : hashMap.keySet()) {
            if (hashMap.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Question35 q = new Question35();
        System.out.println(q.firstNotRepeatChar("abaccdeff"));
    }
}
