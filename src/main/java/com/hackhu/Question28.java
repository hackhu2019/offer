package com.hackhu;

public class Question28 {
    /**
     * 输入一个字符串，输出其字符所有的排列组合
     * 递归，回溯法，每次从字符串中挑出一个无重复字符，与后续任意字符交换
     * 当交换区间为 1 时，不交换
     * @param str
     */
    public void permutation(String str){
        if (str == null || str.length() < 2) {
            return;
        }
        permutation(str.toCharArray(),0);
    }

    /**
     * 将字符串分为已交换区和未交换区两个部分，每次从将未交换区选取任意字符和后续任意位置字符交换位置
     * 可以保持位置不变，所有字符只能在当前索引后半部分选择数字交换防止重复
     * 当无序区间为 1 时，不用再交换，直接输出当前组合
     * @param str
     * @param index
     */
    public void permutation(char[] str, int index) {
        if (index == str.length-1) {
            System.out.println(str);
        }
        for (int i = index; i < str.length; i++) {
            char temp = str[index];
            str[index] = str[i];
            str[i] = temp;
            permutation(str, index+1);
            // 还原
            str[i] = str[index];
            str[index] = temp;
        }
    }

    public static void main(String[] args) {
        Question28 q = new Question28();
        q.permutation("ab");
    }
}
