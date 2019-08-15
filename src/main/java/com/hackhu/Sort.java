package com.hackhu;

import java.util.Arrays;

public class Sort {
    /**
     * 实现插入排序
     * 将元素分为有序区和无序区两个部分
     * 每次从无序区取出一个数，将数据搬迁，将数字插入无序区有序位置，
     * @param nums
     */
    public void insertSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // 默认第一数为有序区
        for (int i = 1; i < nums.length; i++) { // 无序区
            int j = i-1;
            int temp = nums[i];
            // 逆序查找有序区插入位置，当 temp<nums[j] 时插入
            for (; j >= 0; j--) {
                if (nums[j] > temp) {
                    // 将数据搬迁
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j+1] = temp;
        }
    }

    /**
     * 归并排序
     * 将数组分为一各个小块，对每一块进行排序再合并
     * @param nums
     */
    public void mergeSort(int[] nums,int start,int end){
        // 当元素数量小于 3 时，不再向下分
        if (end == start) {
            return;
        }
        if (end - start == 1) {
            if (nums[start] > nums[end]) {
                swap(nums, start, end);
            }
            return;
        }
        int mid = (start + end) >>> 1;
        // 排序左区间
        mergeSort(nums, start, mid);
        // 排序右区间
        mergeSort(nums, mid + 1, end);
        // 合并两个有序区间
        merge(nums, start, mid, mid + 1, end);
    }

    /**
     * 合并两个有序数组
     */
    public void merge(int[] nums,int start1,int end1,int start2,int end2){
        int len = end2 - start1 + 1;
        int[] temp = new int[len];
        int index = 0;
        // 借用临时数组存储
        while (index < len) {
            if (start2>end2||(start1<=end1&&nums[start1] <= nums[start2])) {
                temp[index] = nums[start1];
                start1++;
            } else {
                temp[index] = nums[start2];
                start2++;
            }
            index++;
        }
        // 赋值给 nums
        while (len > 0) {
            nums[end2--] = temp[--len];
        }
    }

    public void quickSort(int[] nums, int start, int end) {
        // 当元素数量小于 3 时，不再向下分
        if (end == start) {
            return;
        }
        if (end - start == 1) {
            if (nums[start] > nums[end]) {
                swap(nums, start, end);
            }
            return;
        }
        int mid = (start + end) >>> 1; // 取中间数
        int left = start,
                right = end;
        while (left < right) {
            if (nums[left] <= nums[mid]) {
                left++;
            }
            if (nums[right] >= nums[mid]) {
                right--;
            }
            if (nums[left] > nums[mid] && nums[right] < nums[mid]) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        quickSort(nums, start, mid);
        quickSort(nums,mid+1,end);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        sort.quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
