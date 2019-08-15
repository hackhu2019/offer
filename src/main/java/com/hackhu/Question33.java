package com.hackhu;

import java.util.*;

public class Question33 {
    /**
     * 问题：输入一串数字，输出其组合的最小数字
     * 定义排序规则，两个字符串，谁组成的字符值更小谁放前面（与 hashcode 相关）
     * @param nums
     */
    public void printMinNum(int[] nums) {
        List<String> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num+"");
        }
        // 自定义排序规则，
        Collections.sort(list,(String o1,String o2)->{
            return (o1+o2).hashCode()-(o2+o1).hashCode(); // 根据二者组合数的大小排序
        });
        for (String s : list) {
            System.out.print(s);
        }
    }

    public static void main(String[] args) {
        Question33 q = new Question33();
        int[] nums = {3, 32, 321,112,2};
        q.printMinNum(nums);
    }
}
