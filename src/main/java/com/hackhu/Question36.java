package com.hackhu;

import java.util.Arrays;

public class Question36 {
    /**
     * 问题：统计字符串中的逆序对数
     * 通过归并排序的思路统计逆序对数
     * @param nums
     * @return
     */
    public int countInversePairs(int[] nums){
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int count = inversePairs(nums, 0, nums.length - 1);
        return count;
    }

    /**
     * 归并排序，并统计逆序度
     * 逆序度=左逆序度+右逆序度+合并逆序对
     * 合并逆序度，从末尾开始比较，当左数大于右数时，逆序度为右数索引到左数左边界之差+1
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int inversePairs(int[] nums, int start, int end) {
        if (end - start == 0) {
            return 0;
        }
        if (end - start == 1) {
            if (nums[start] > nums[end]) {
                swap(nums, start, end);
                return 1;
            }
            return 0;
        }
        int mid = (start + end) >>> 1; // 取中位数
        int point = mid + 1;
        int count = inversePairs(nums, start, mid) + inversePairs(nums, point, end); // 左右排序好，再记录左右逆序度
        int[] temps = new int[end - start + 1];
        for (int i = temps.length-1; i >= 0 ; i--) {
            if (end < point) {
                temps[i] = nums[mid];
                mid--;
            } else if (mid < start) {
                temps[i] = nums[end];
                end--;
            } else {
                // 当左数大于右数时，逆序度为右数索引到左数左边界之差+1
                if (nums[mid] > nums[end]) {
                    temps[i] = nums[mid];
                    count += end - point + 1;
                    mid--;
                } else {
                    temps[i] = nums[end];
                    end--;
                }
            }
        }
        for (int i = 0; i < temps.length; i++) {
            nums[start + i] = temps[i];
        }
        return count;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        Question36 q = new Question36();
        int[] nums = {7,5,6,4};
        System.out.println(q.countInversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }

}
