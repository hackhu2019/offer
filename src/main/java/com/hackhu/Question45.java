package com.hackhu;

import java.util.ArrayList;
import java.util.List;

public class Question45 {
    /**
     * 题：0，1，..,n-1 这 n 个数字排成一个圆圈，从数字 0 开始每次从这个圆圈里删除第 m 个数字，求这个圆圈里剩下的最后一个数字 —— 报数类问题
     * 解法1：环型链表模拟报数过程真正删除链表结点，返回最后剩余结点。—— 易实现，但是空间复杂度过高，需要开辟相应的空间存储
     * 解法2：
     * 映射公式 (f(n-1,m)+m)%n (n=1 时返回 0)
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining1(int n,int m){
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) { // 初始化链表，尾部插入
            list.add(list.size(), i);
        }
        int last = 0;
        while (list.size() > 1) {
            last = (last + m - 1) % list.size(); // 计算当前需删除数字坐标
            list.remove(last);
        }
        return list.get(0);
    }

    public int lastRemaining2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
    public static void main(String[] args) {
        Question45 q = new Question45();
        System.out.println(q.lastRemaining1(10,10));
        System.out.println(q.lastRemaining2(10,10));
    }
}
