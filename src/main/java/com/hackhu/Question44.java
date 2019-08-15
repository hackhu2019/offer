package com.hackhu;

import java.util.Arrays;

public class Question44 {
    /**
     * 题目：从扑克牌中随机抽取 5 张牌，判断是不是一个顺子，即这 5 张牌是不是连续的。
     * 2~10 为数字本身，A 为 1，Q 为 12，K 为 13,大王小王可以为任意数字（0）
     * 特殊情况：出现对子一定不为顺子
     * 思路分析：先将数字排序，若数组排序后第一个不为0，且出现相邻差值不为 1 直接返回 false，都为 1 返回 true
     * countZero 记录 0 个数，diff 为差值，则应返回差值为 5+countZero,若 diff 大于则返回 false，否返回true
     * @param nums
     * @return
     */
    public boolean isContinuous(int[] nums){
        Arrays.sort(nums);
        int countZero = 0;
        int diff = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i + 1]) { // 出现对子直接返回 false
                return false;
            }
            countZero += nums[i] == 0 ? 1 : 0;
            diff += nums[i+1] - nums[i];
        }
        return 5 + countZero >= diff;
    }

    public static void main(String[] args) {
        Question44 q = new Question44();
        int[] nums = {5,4,3,2,1};
        System.out.println(q.isContinuous(nums));
    }
}
