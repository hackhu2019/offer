package com.hackhu;

import java.util.Arrays;

public class Question52 {
    /**
     * 题：给定一个数组 A[0,1,..,n-1]，请构建一个数组 B[0,1,..,n-1]，其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*A[n-1]
     * 不能使用除法。—— 即 B[i]=A乘积/A[i]
     * 将B[i] 分为两部分 C[i]*D[i], C[i]=C[i-1]*A[i-1],D[i]=D[i+1]*A[i+1]
     * @param nums
     * @return
     */
    public int[] multiply(int[] nums) {
        if (nums == null) {
            return nums;
        }
        int[] result = new int[nums.length];
        int[] c = new int[nums.length];
        c[0] = 1;
        for (int i = 1; i < nums.length; i++) { // C[i]=C[i-1]*A[i-1]
            c[i] = c[i - 1] * nums[i - 1];
        }
        int temp = 1; // D[i]
        for (int i = nums.length-1; i >=0 ; i--) {
            result[i] = c[i] * temp; // B[i]=C[i]*D[i]
            temp *= nums[i]; // D[i]=D[i+1]*A[i+1]
        }
        return result;
    }

    public static void main(String[] args) {
        Question52 q = new Question52();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(q.multiply(nums)));
    }
}
