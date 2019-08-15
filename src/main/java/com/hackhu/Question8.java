package com.hackhu;

public class Question8 {
    /**
     * 在旋转数组中寻找最小值
     * 根据二分查找法，找到数组旋转点（数组元素可能重复）
     * 特殊情况：中位数、左边界值、右边界值相等，则无法使用二分查找法，只能顺序遍历，找出最小值
     * 当左边界值大于右边界值，选取中位数，旋转点在非递增区间
     * 区间为 1 ，取最小值
     * @param nums
     * @return
     */
    public int findRotatingArraysMinValue(int[] nums) throws Exception {
        if (nums == null ) {
            throw new Exception("查找数组不能为空");
        }
        int midIndex = 0;
        int left = 0, right = nums.length - 1;
        while (nums[left] >= nums[right]) {
            if (right - left <= 1) {
                midIndex = nums[left] <= nums[right] ? left : right;
                break;
            }
            midIndex = (right + left) >>> 1; // 取中位数
            // 处理乱序情况，无法用二分查找法
            if ((nums[left] == nums[midIndex] && nums[right] == nums[midIndex])
                 ||(nums[left] > nums[midIndex] && nums[right] <
                    nums[midIndex])) {
                return findMin(nums, left, right);
            }  else if (nums[midIndex] >= nums[left]) {
                left = midIndex;
            } else {
                right = midIndex;
            }
        }
        return nums[midIndex];
    }
    private int findMin(int[] nums,int start,int end){
        int min = nums[start];
        for (int i = start+1; i <= end; i++) {
            if (nums[i]<min) {
                min = nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        Question8 question = new Question8();
        int[] nums = {5,4,3,1};
        System.out.println(question.findRotatingArraysMinValue(nums));
    }
}
