package com.hackhu;

/**
 * 题：求 1+2+...+n，要求不能使用乘除法、for、while、if、else、switch、case 等关键字以及条件判断语句
 * 尝试用位运算替换加减乘除运算，书上提供的方法不太式原于 Java 和 C#
 */
public class Question46 {
    public int sum(int n) {
        return (int)(n+Math.pow(n,2))>>>1;
    }

    public static void main(String[] args) {
        Question46 q = new Question46();
        System.out.println(q.sum(3));
    }
}
