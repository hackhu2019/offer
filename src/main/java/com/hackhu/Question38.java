package com.hackhu;

public class Question38 {
    /**
     * 问题：统计一个数字在排序数组中出现的次数
     * 对于有序数组首先要联想到「二分查找」，这道题也是二分查找的变题，我们可以把它看做
     * 找到数字 K 在有序数列中第一次出现以及最后一次出现的范围（right-left）+1
     * @param nums
     * @param k
     * @return
     */
    public int getKCount(int[] nums,int k){
        if (nums == null || nums.length < 1||nums[0]>k||nums[nums.length-1]<k) {
            return 0;
        }
        int count = getKLast(nums, 0, nums.length - 1, k) - getKFirst(nums, 0, nums.length - 1, k) + 1;
        return count;
    }

    /**
     * 找到 K 第一次出现的索引，未找到 k 返回 start\end+1
     * @param nums
     * @param start
     * @param end
     * @param k
     * @return
     */
    public int getKFirst(int[] nums,int start,int end,int k){
        while (start < end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] > k) {
                end = mid - 1;
            } else if (nums[mid] < k) {
                start = mid + 1;
            } else {
                if (mid == start || nums[mid - 1] != k) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return start;
    }
    // 未找到 k 返回 end\start-1
    public int getKLast(int[] nums,int start,int end,int k){
        while (start < end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] > k) {
                end = mid - 1;
            } else if (nums[mid] < k) {
                start = mid + 1;
            } else {
                if (mid == end || nums[mid +1] != k) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5};
        Question38 q = new Question38();
        System.out.println(q.getKCount(nums,0));
    }
}
