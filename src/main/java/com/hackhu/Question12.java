package com.hackhu;

public class Question12 {
    /**
     * 输入位数，打印从 1 到指定位数之间的所有数
     * 一个数的每一位都是 0~9 的组合，确定位数则创建大小为 n 的数组，存放数组每一位的组合
     * printOneToMaxOfDigits 补齐每一组组合起始位（0~9）
     * 由 printToMaxOfDigitsRecursively 枚举组合，补齐每一位
     * @param n
     */
    public void printOneToMaxOfDigits(int n){
        if (n <= 0) {
            return;
        }
        int[] numbers = new int[n];
        for (int i = 0; i < 10; i++) {
            numbers[0] = i;
            printToMaxOfDigitsRecursively(numbers, 1);
        }
    }

    /**
     * 回溯法，枚举每一位数的可能，当补齐到最后一位时，输出组合数
     * @param numbers
     * @param index 当前要补齐位数
     */
    private void printToMaxOfDigitsRecursively(int[] numbers,int index){
        if (index == numbers.length) { // 组合完成，输出该组合
            printNum(numbers);
            return;
        }
        for (int i = 0; i < 10; i++) {
            numbers[index] = i;
            printToMaxOfDigitsRecursively(numbers, index + 1);
        }
    }

    /**
     * 输出组合
     * @param nums
     */
    private void printNum(int[] nums){
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) { // 起始的 0 忽略，不打印
            if (flag && nums[i] != 0) {
                flag = false;
            }
            if (!flag) {
                System.out.print(nums[i]);
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Question12 question12 = new Question12();
        question12.printOneToMaxOfDigits(3);
    }
}
