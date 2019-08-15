package com.hackhu;

import java.util.Arrays;

public class Question43 {
    /**
     * 问题：把 N 个骰子扔在地上，所有骰子朝上一面的点数之和为 s。输入 N 打印出 s 的所有可能性
     * 思路1：暴力枚举骰子点数出现的所有可能进行统计 —— 时间复杂度高，存在重复计算
     * 思路2：记录上一总和出现概率，当前和为 n 的次数为上一总和 (n-1)次数+（n-2）次数+...+（n-6）次数之和
     * @param n
     * @return
     */
    public void printProbability(int n) {
        if (n < 1) {
            return ;
        }
        int[][] probabilities = new int[2][]; // 两个数组，轮流表示上一总和次数、当前总和次数，6*n 为骰子之和最大数，+1 空出一位方便计算
        probabilities[0] = new int[6 * n + 1];
        probabilities[1] = new int[6 * n + 1];
        for (int i = 0; i < 6*n+1; i++) { // 初始化总和
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }
        int flag = 0; // 记录上一总和次数
        for (int i = 1; i <= 6; i++) { // 初始化 1 个骰子总和出现概率
            probabilities[flag][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6*i; j++) {
                probabilities[1 - flag][j] = 0; // 初始化当前总和次数
                for (int k = 1; k <= 6; k++) { // 当前和为 n 的次数为上一总和 (n-1)次数+（n-2）次数+...+（n-6）次数之和
                    if (k >= j) { // 当前和小于骰子大小时，不存在上一概率，直接计算上一总可能
                        break;
                    }
                    probabilities[1 - flag][j] += probabilities[flag][j - k];
                }
            }
            flag = 1 - flag;
        }
        int total = (int) Math.pow(6, n);
        System.out.printf(n+" 个骰子：");
        for (int i = n; i <= 6*n ; i++) {
            System.out.print("骰子向上面之和为:" + i + " 出现概率约为: ");
            System.out.printf("%.6f\n",(float) probabilities[flag][i] / total);
        }
    }

    public static void main(String[] args) {
        Question43 q = new Question43();
        q.printProbability(6);
    }
}
