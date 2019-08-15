package com.hackhu;

public class Question11 {
    /**
     * 输入一个数 Num 以及其阶乘数 n，求运算结果
     * 考虑特殊情况，当 nums 为负数时？
     * 当阶乘 n 为 偶数时，运算结果与其绝对值运算结果一致
     * 当阶乘为奇数时，运算结果为 其绝对值运算结果取反
     * 当阶乘数 n 为负数时？
     * 为运算 1.0/绝对值阶乘结果
     * @param num
     * @param n
     * @return
     */
    public double power(double num,int n) {
        if (num < 0&&n%2==1) {
            return -powerUnSign(-num, n);
        }
        if (n < 0) {
            return 1.0 / powerUnSign(num, -n);
        }
        return powerUnSign(num, n);
    }

    private double powerUnSign(double num, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return num;
        }
        // n 为奇数 a^n=a^(n-1)/2+a^(n+1)/2,n 为奇数 a^n=a^n/2+a^n/2
        return n%2==0? powerUnSign(num, n >> 1) * powerUnSign(num, n >> 1):powerUnSign(num, (n-1) >> 1) * powerUnSign(num, (n+1) >> 1);
    }

    public static void main(String[] args) {
        Question11 q = new Question11();
        System.out.println(q.power(10,-2));
    }
}
