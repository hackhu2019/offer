package com.hackhu;

public class Question29 {
    /**
     * 问题：找到数组中超过半数的数字
     * 解法 1，排序数组，因为超过半数，所以，排序后数组的中位数就是出现次数最多（超过半数）的数
     * 解法 2, 统计出现每个数的出现次数，初始次数为 1，当出现不同数字时次数减一，当有数字次数超过一半结束循环，或遍历结束，最终返回的是出现次数最多的数字
     * 解法 3, 使用哈希表统计每个数字出现的频率，可以发现不存在超过半数数字情况
     * @param nums
     * @return
     */
    public int findMoreThanHalfNum(int[] nums) throws Exception {
        if (nums == null) {
            throw new Exception("数组不能为空");
        }
        int key = nums[0],
                value = 1;
        int mid = nums.length / 2;
        for (int i = 1; i < nums.length ; i++) {
            // 不同数字，频率 -1
            if (nums[i] != key) {
                value--;
                if (value == 0) { // 次数不足，更换数字
                    key = nums[i];
                    value = 1;
                }
            } else { // 相同次数频率+1
                value++;
                if (value > mid) { // 频率过半，结束循环
                    break;
                }
            }
        }
        return key;
    }

    public static void main(String[] args) throws Exception {
        Question29 q = new Question29();
        int[] nums = {1, 2, 3, 3, 3,6,6,6,6,6,6};
        System.out.println(q.findMoreThanHalfNum(nums));
    }
}
