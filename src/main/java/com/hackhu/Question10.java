package com.hackhu;

public class Question10 {
    /**
     * 统计二进制数 1 的个数
     * 利用位运算「与运算」特性，每次 num &= num - 1，消除最高位
     * @param num
     * @return
     */
    public int countOne(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num &= num - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = -99999;
        System.out.println("二进制数:" + num);
        System.out.println("转换为二进制"+Integer.toBinaryString(num));
        Question10 question = new Question10();
        System.out.println("二进制 1 个数："+question.countOne(num));
    }
}
