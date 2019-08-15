package com.hackhu;

public class Question30 {
    /**
     * 输入数组，打印其中最小的 K 个数
     * 解法1，基于快速排序，分区左分区为大于 mid 的数，右分区为大于 mid 的数，当左区间为 k 时，打印数组中左区间数即可
     * 解法2，建立容量为 k 的大顶堆，依次遍历数组，维护堆，结束后输出堆数据即可
     * @param nums
     * @param k
     */
    public void printLeastKNums(int[] nums,int k) {
        // 排查空指针、超出数组范围等情况
        if (nums == null || nums.length < k) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = partition(nums,left,right);
        while (mid != k - 1) {
            if (mid > k - 1) { // 区间超过范围，在左区间寻找
                mid = partition(nums, left, mid);
            } else {
                mid = partition(nums, mid + 1, right);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]+" ");
        }
    }
    private int partition(int[] nums,int left,int right) {
        int mid = (right + left) >>> 1;
        while (left < right) {
            if (nums[left] <= nums[mid]) {
                left++;
            }
            if (nums[right] >= nums[mid]) {
                right--;
            }
            if (nums[left] > nums[mid] && nums[right] < nums[mid]) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1,-1,7};
        Question30 q = new Question30();
        q.printLeastKNums(nums,5);
    }
}
