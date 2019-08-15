package com.hackhu;

public class Question32 {
    /**
     * 输入一个整数 n，求 1 到 n 这 n 个整数的十进制表示中 1出现的次数
     *
     * @param n
     * @return
     */
    public int numberOfOne(int n) {
        int count = 0;
        int i = 1;
        int cur = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            cur = (n / i) % 10; // 余数
            before = n / (i * 10); // 商
            after = n - (n / i) * i; // 尾数
            if (cur > 1) {
                count += (before + 1) * i;
            } else if (cur == 0) {
                count += before * i;
            } else if (cur==1){
                count += before * i + after + 1;
            }
            i *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Question32 q = new Question32();
        System.out.println(q.numberOfOne(9));
    }
}
