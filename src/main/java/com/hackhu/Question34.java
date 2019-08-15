package com.hackhu;

import java.util.ArrayList;
import java.util.List;

public class Question34 {
    /**
     * 丑数：因式分解后只包含 2 3 5 的数，1 为最小的丑数
     * 输入一个数找出 1~end 中的丑数
     * 下一个丑数为之前丑数 *2 或 *3 *5 的结果
     * 从之前已获得丑数中取依序 *2 或 *3 *5 找出恰好大于当前最大丑数（最后添加丑数）的索引，下一次从记录坐标开始遍历即可
     * 丑数依序生成，最大值永远为最新加入的丑数
     * @param end
     * @return
     */
    public List<Integer> getUglyNum(int end){
        if (end < 1) {
            return new ArrayList<>();
        }
        List<Integer> uglys = new ArrayList<>();
        int u1 = 0, u2 = 0, u3 = 0; // 分别记录当前丑数集合中 *2 或 *3 *5 <= 丑数集合当前最大值索引
        uglys.add(1);
        int min = minNum(uglys.get(u1)*2,uglys.get(u2)*3,uglys.get(u3)*5);
        // 当下一最小丑数超过范围，则结束循环
        while (min < end) { // 每次添加最小丑数
            uglys.add(min);
            while (u1+1<uglys.size()&& uglys.get(u1) * 2 <= min) { // 更新最大边界值索引
                u1++;
            }
            while (u2+1<uglys.size()&& uglys.get(u2) * 3 <= min) {
                u2++;
            }
            while (u3+1<uglys.size()&& uglys.get(u3) * 5 <= min) {
                u3++;
            }
            min = minNum(uglys.get(u1)*2,uglys.get(u2)*3,uglys.get(u3)*5); // 更新最大丑数
        }
        return uglys;
    }

    private int minNum(int u1, int u2, int u3) {
        int min = u1 > u2 ? u2 : u1;
        return min > u3 ? u3 : min;
    }

    public static void main(String[] args) {
        Question34 q = new Question34();
        System.out.println(q.getUglyNum(1500));
    }
}
