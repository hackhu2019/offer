package com.hackhu;

public class Question31 {
    /**
     * 问题：输入含有正数或负数的数组，找到相加和最大的连续组合，并返回其和
     * 思路：maxSum 存储连续最大和，sum 存储上一连续数字之和，都初始化为 nums[0]
     * 依序遍历数组，当上一组合为负数或 0 时，放弃上一组合，sum 为当前遍历元素
     * 当上一组合为正数时，则加上当前遍历元素
     * 判断当前组合之和 sum 是否大于 maxSum ，是更新 maxSum，否不更新，继续遍历
     * @param nums
     * @return
     */
    public int findLargestSumOfArrays(int[] nums){
        if (nums == null||nums.length<1) {
            throw new NullPointerException("数组不能为空");
        }
        int maxSum = nums[0],
                sum = maxSum;
        for (int i = 1; i < nums.length; i++) {
            // 模拟求解思路，放弃上一非正数解
            if (sum <= 0) {
                sum = nums[i];
            }else {
                sum += nums[i];
            }
            // maxSum 存储最大组合
            maxSum = sum > maxSum ? sum : maxSum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Question31 q = new Question31();
        int[] nums = {-1, 3,-2, 1, 2, 3};
        System.out.println(q.findLargestSumOfArrays(nums));
    }
}
