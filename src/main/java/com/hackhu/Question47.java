package com.hackhu;

import java.util.Arrays;

public class Question47 {
    /**
     * 题：写一个函数，求两个整数之和，要求在函数体内不得使用 +、-、*、/ 四则运算符号
     * 思路分析，能够替换四则运算的只有位运算，常用位运算有：与、或、非、异或（&、\、~、^），左移、右移、无符号右移（<<、>>、>>>）
     * 联想二进制加法 1、0 变化，只有当二者为（1、0）或（0，1）时相加结果为 1，其余都为 0,与异或计算相似
     * 进位发生在二者都是 1 的时候，同与运算一致，进位操作可以看作左移
     * 注意：进位可能出现连续。可以模拟 15 + 7 的二进制计算过程
     * @param num1
     * @param num2
     * @return
     */
    public int add(int num1,int num2){
        int carry = 0, sum = 0;
        while (num2 != 0) { // 无进位时结束
            sum = num1 ^ num2; // 先做异或
            carry = (num1 & num2) << 1; // 计算进位
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

    /**
     * 不用其余变量，交换二者的值
     * 解法1；a=a*b,b=a/b;a=a/b ; a=a+b,b=a-b;a=a-b 可能会溢出
     * 解法2: 利用异或特性，A^A=0, 任意数^0 = 它本身
     * @param nums
     * @param index1
     * @param index2
     * @return
     */
    public void swap(int[] nums,int index1,int index2){
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] ^= nums[index1];
        nums[index1] ^= nums[index2];
    }

    public static void main(String[] args) {
        Question47 q = new Question47();
        int[] nums = {15, 7};
        System.out.println(q.add(-15, -7));
        q.swap(nums, 0, 1);
        System.out.println(Arrays.toString(nums));
    }
}
