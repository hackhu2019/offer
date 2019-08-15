package com.hackhu;

public class Question9 {
    /**
     * 计算斐波那契数列的答案
     * f(1)=1,f(0)=0
     * f(n)=f(n-1)+f(n-2)
     * @param n
     * @return
     */
    public long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 1;
        int preOne = 1;
        int preTwo = 0;
        for (int i = 1; i < n; i++) {
            // f(n)=f(n-1)+f(n-2)
            result = preOne + preTwo;
            // f(n-2) 为前一次计算的 f(n-1)
            preTwo = preOne;
            // f(n-1) 为前一次计算的 f(n)
            preOne = result;
        }
        return result;
    }

    /**
     * 斐波那契数列的升级，用 1*2 的矩形，填满一个 2*N 的大矩形（横放或竖放），问有多少种填法
     * @return
     */
    public int fibonacciPlus(int width){
        if (width == 1) {
            return 1;
        }
        if (width == 2) {
            return 2;
        }
        return fibonacciPlus(width - 1) + fibonacciPlus(width - 2);
    }
    public long power(int num,int e) {
        if (e ==1) {
            return num;
        }
        return e%2==0? power(num, e / 2) * power(num, e / 2):power(num, (e-1) / 2) * power(num, (e+1) / 2);
    }

    public static void main(String[] args) {
        Question9 question = new Question9();
//        System.out.println(question.power(2,10));
        System.out.println(question.fibonacciPlus(4));
//        System.out.println(question.fibonacci(0));
    }
}
