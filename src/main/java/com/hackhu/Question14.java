package com.hackhu;

import java.util.Arrays;

public class Question14 {
    /**
     * 将将数组中的奇数全部排在偶数之前
     * @param nums
     */
    public void ReOrder(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (condition(nums[left], nums[right])) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            } else if (nums[left] % 2 == 1) {
                left++;
            } else if (nums[right]%2==0){
                right--;
            }
        }
    }
    private boolean condition(int num1,int num2){
        if (num1 % 2 == 0 && num2 % 2 == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Question14 question14 = new Question14();
        int[] nums = {1,3,5,7,8};
        question14.ReOrder(nums);
        System.out.println(Arrays.toString(nums));
    }
}
