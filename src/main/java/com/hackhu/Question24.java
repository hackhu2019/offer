package com.hackhu;

public class Question24 {
    /**
     * 输入数组以及长度，判断其是否为二叉查找树的后序遍历
     * 后序遍历特点：最后一个输出的为根节点
     * 二叉查找树特点，所有的左子树都小于等于根节点，所有的右子树都大于等于根节点
     * 根据二叉查找树特点，以根节点确定左右子树区间
     * 判断是否所有的右子树都大于根节点，否返回 false
     * 满足则继续判断子树是否也满足二叉查找树特点
     * 全都满足，返回 true
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public boolean verifySequenceOfBSF(int[] nums,int start,int end){
        if (nums == null||start>=end) {
            return true;
        }
        int root = nums[end];
        int dividPoint = 0;
        int i = start;
        // 找到分界点
        for (; i <end ; i++) {
            if (nums[i] > root) {
                break;
            }
        }
        dividPoint = i;
        boolean left = verifySequenceOfBSF(nums, start, dividPoint-1); // 验证子树是否满足二叉查找树
        // 验证右子树是否都小于等于根节点
        for (; i <= end; i++) {
            if (nums[i] < root) {
                return false;
            }
        }
        boolean right = verifySequenceOfBSF(nums, dividPoint, end-1); // 验证子树是否满足二叉查找树
        return left && right;
    }

    public static void main(String[] args) {
        Question24 q = new Question24();
        int[] nums = {7,4,6,5};
        System.out.println(q.verifySequenceOfBSF(nums,0,nums.length-1));
    }
}
