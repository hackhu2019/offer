package com.hackhu;

public class Question65 {
    /**
     * 题：给定一个数组和滑动窗口的大小，找出所有滑动窗口中的最大值
     * 思路分析：这道题可以直接看成找出数组中的最大值
     * @param nums
     * @param windowSize
     * @return
     */
    public int maxInWindow(int[] nums, int windowSize) {
        if (nums == null ||nums.length<1|| windowSize >= nums.length) {
            return -1;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        Question65 q = new Question65();
        System.out.println(q.maxInWindow(nums,3));
    }
}
