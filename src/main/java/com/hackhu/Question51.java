package com.hackhu;

import java.util.Arrays;

public class Question51 {
    /**
     * 题：在一个长度为 n 的数组中，所有的数字都在 0~n-1 的范围内。数组中的某些数字是重复的，但不知有几个数重复，也不知道数字重复了几次。
     * 找出数组中任意重复的数字。
     * 解题思路：从题目中找到规律，数组长度为 n，且所有数字都在在 0~n-1 的范围内,数组下标和值形成了对应关系
     * 一次遍历，每遍历一数将其放到对应下标，若已存在相同数则返回当前遍历数
     * @param nums
     * @return
     */
    public int duplicate(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int i = 0;
        while (i < nums.length) {
            if (i != nums[i] && nums[i] == nums[nums[i]]) { // 对应下标已有对应数，说明当前遍历数为重复数
                return nums[i];
            } else if (nums[nums[i]] != nums[i]) { // 将数放置对应下标位置，索引值不变
                swap(nums, i, nums[i]);
            } else { // nums[nums[i]] = nums[i] 位置正确，遍历下一数
                i++;
            }
        }
        return -1;
    }

    private void swap(int[] nums,int index1,int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        Question51 q = new Question51();
        int[] nums = {5,4,2,2,1,1};
        System.out.println(q.duplicate(nums));
        System.out.println(Arrays.toString(nums)); // 检测数组是否放置正确
    }
}
