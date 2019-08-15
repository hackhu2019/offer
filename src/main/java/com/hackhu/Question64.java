package com.hackhu;

import java.util.Arrays;

public class Question64 {
    /**
     * 题：获得数据流中的中位数。若数据流长度为奇数，则中位数为排序后最中间的数；若为偶数，中位数为中间两数的平均数
     * 解法1：快速排序数据，K=流的长度/2 ,奇数时返回第 K 个数，偶数时，返回第 K、K+1 个数平均数
     * 解法2：维护一个大小为 K 的大顶堆，一个大小为 len-k 的小顶堆，遍历完数据流后，若流为奇数项，大顶堆堆顶的数就是中位数，偶数项，则为大顶堆、小顶堆堆顶平均数
     * @param nums
     * @return
     */
    public int getMedian(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        Arrays.sort(nums);
        int mid = nums.length >> 1;

        // 奇数时返回第 K 个数，偶数时，返回第 K、K+1 个数平均数
        return nums.length % 2 == 0 ? (nums[mid] + nums[mid + 1]) >>> 1 : nums[mid];
    }
}
