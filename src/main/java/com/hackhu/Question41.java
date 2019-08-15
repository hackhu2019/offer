package com.hackhu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question41 {
    /**
     * 问题：输入升序数组以及一个数字 target。在数组中查找两个数，使他们相加之和正好与 target 相等
     * 双指针法，left、right 分别从左往右、从右往左扫描，当相加之和小于 target，left 移动，大于目标值 right 移动
     * 相等结束循环，返回查找结果
     * @param nums
     * @param target
     * @return
     */
    public int[] findNumsWithSum(int[] nums,int target){
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int left = 0, right = nums.length-1;
        int[] result = {0, 0};
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            }
        }
        return result;
    }

    /**
     * 输入一个正数，打印出所有和为 target 的连续正序数列，至少含有两个数，则该数最大为 (target+1)/2
     * 回溯法，依次建立连续序列，当前序列之和大于 target ，结束递归（剪枝）
     * 当前序列之和小于 target ，继续添加下一顺序数
     * 当前序列之和登于 target ，结束递归，添加当前序列
     *
     * @param target
     * @return
     */
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> findContinueSequence(int target){
        for (int i = 1; i < (target+1)>>>1; i++) {
            findContinueSequence(new ArrayList<Integer>(), i, target);
        }
        return results;
    }

    private void findContinueSequence(List<Integer> result, int cur,int target) {
        if (cur > target) {
            return;
        } else if (cur == target) {
            result.add(cur);
            results.add(result);
            return;
        } else {
            result.add(cur);
            findContinueSequence(result, cur+1,target - cur);
        }
    }

    public static void main(String[] args) {
        Question41 q = new Question41();
//        int[] nums = {1, 2, 4, 7, 11, 15};
//        System.out.println(Arrays.toString(q.findNumsWithSum(nums,15)));
        System.out.println(q.findContinueSequence(15));
    }
}
