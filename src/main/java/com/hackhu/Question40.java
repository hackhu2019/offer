package com.hackhu;

import java.util.Arrays;

public class Question40 {
    /**
     * 异或特性，A^A 异或得 0，A^B 二进制至少有 1 位为 1
     * 同则为 0 ，异则为 1
     * 问题：输入数组，其中只有 1 个数出现 1 次，其余所有数都出现 2 次，求该只出现 1 次的数
     * @param nums
     * @return
     */
    public int findNumAppearOnce(int[] nums) {
        if (nums == null||nums.length<1) {
            return -1;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    /**
     * 问题：输入数组，其中只有 2 个数出现 1 次，其余所有数都出现 2 次，求只出现 1 次的两个数
     * 借鉴找 1 个只出现 1 次数的思路，将 1 个数组分为两个，分别包含 1 个只出现 1 次的数字
     * 如何划分数组？ —— 异或特性，两个数不同 A^B 二进制至少有 1 位为 1，求出数组异或结果，求出二进制第一个 1 出现位置
     * 根据二进制位数不同划分数组
     * @param nums
     * @return
     */
    public int[] findNumsAppearOnce(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int result = 0;
        int[] results = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        String binaryNum = Integer.toBinaryString(result);
        int n =binaryNum.length()- binaryNum.lastIndexOf('1'); // 记录二进制第一个 1 的位置(从右往左数)
        for (int i = 0; i < nums.length; i++) {
            if (isBinaryBitSame(nums[i], n)) {
                results[0] ^= nums[i];
            } else {
                results[1] ^= nums[i];
            }
        }
        return results;
    }
    /**
     * 输入一个数，以及指定的二进制位，判断该数的二进制位与指定位是否一致(从右往左数)
     * 将十进制数转换为二进制数，判断 n 是否超出 num 长度，是返回 false
     * 否则判断改索引位数是否为 1，是返回 true ，否，返回 false
     * @param num
     * @param n
     * @return
     */
    private boolean isBinaryBitSame(int num,int n){
        String str = Integer.toBinaryString(num);
        if (str.length() > n && str.charAt(str.length()-n)=='1') {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {2,4,3,6,3,2,5,5};
        Question40 q = new Question40();
        // System.out.println(q.isBinaryBitSame(1,0));
        System.out.println(Arrays.toString(q.findNumsAppearOnce(nums)));
    }
}
