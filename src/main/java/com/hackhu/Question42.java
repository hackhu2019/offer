package com.hackhu;

import java.util.Arrays;

public class Question42 {
    /**
     * 输入一个英文句子，翻转句子中单词顺序，单词顺序不变，标点符号和普通字母一样处理
     * 解法1：将字符串以空格切分，得到数组，将数组成员的顺序调换即可
     * 解法2：将切分后的数组倒序加入 reverseStr，返回 reverseStr
     * 解法1、解法2 问题，针对多个空格翻转后不一致
     * 解法三，先使用 reverse 函数将字符串整个翻转，再将单个字符翻转
     * @param str
     * @return
     */
    public String reverseSentence(String str){
        if (str == null) {
            return null;
        }
        String[] newStr = str.split(" ");
        StringBuilder reverseStr = new StringBuilder();
        for (int i = newStr.length - 1; i >= 0; i--) {
            reverseStr.append(newStr[i]+" ");
        }
        return reverseStr.toString();
    }

    public String reverseSentence3(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder reverse = new StringBuilder(str);
        reverse.reverse();
        int index = 0, len = reverse.length();
        while (index < len) {
            int start = index;
            while (start<len&&reverse.charAt(start) == ' ') {
                start++;
            }
            int end = start + 1;
            while (end<len&&reverse.charAt(end) != ' ') {
                end++;
            }
            index = end;
            end -= 1;
            // 翻转单词
            while (start < end) {
                char temp = reverse.charAt(start);
                reverse.setCharAt(start, reverse.charAt(end));
                reverse.setCharAt(end, temp);
                end--;
                start++;
            }
        }
        return reverse.toString();
    }

    /**
     * 问题：字符串的左旋操作是把字符串全面的若干个字符串转移到字符串尾部,定义一个函数实现字符串左旋操作
     * 例：输入"abcdefg" 、2 输出 "cdefgab"
     * 解法1：利用字符串拼接，将字符串分为两段（0，n）、（n，len），再将后半段拼接到前半段，返回
     * 解法2：将字符串前后两段翻转，再对整个字符串翻转
     * @param str
     * @param n
     * @return
     */
    public String leftRotateString(String str,int n){
        if (str == null || n < 0 || n >= str.length()) {
            return str;
        }
        return str.substring(n, str.length()) + str.substring(0, n);
    }

    public static void main(String[] args) {
        Question42 q = new Question42();
        System.out.println(q.leftRotateString("abcdefg",2));
    }
}
