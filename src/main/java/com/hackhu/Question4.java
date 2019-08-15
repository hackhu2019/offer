package com.hackhu;

import java.util.Arrays;

public class Question4 {
    /**
     * 将字符数组中的空格替换成 %20 由原来的一位变成 3位，假定字符数组有足够的空间
     * 第一遍遍历字符数组找出已有空格数，
     * 然后从末尾开始移动原数组，依序平移,新的位置为原索引+空格数*2
     * @param str
     */
    public void replaceSpaceToChar(char[] str,int len){
        int count_space = 0;
        for (int i=0;i<len;i++) {
            count_space = str[i] == ' ' ? count_space + 1 : count_space; // 每找到 1 个空格，count_space+1
        }
        for (int i = len - 1; i > 0; i--) {
            if (count_space == 0) { // 若空格数为 0 则不用再平移数组
                return;
            }
            if (str[i] == ' ') {
                str[i+count_space*2] = '0';
                str[i+count_space*2-1] = '2';
                str[i+count_space*2-2] = '%';
                count_space--;
            } else {
                str[i+count_space*2]=str[i];
            }
        }
    }

    public static void main(String[] args) {
        char[] str = {'h', ' ', ' ',' ', 'e',' ',' ',' ',' ',' ',' '};
        Question4 q = new Question4();
        q.replaceSpaceToChar(str,5);
        System.out.println(Arrays.toString(str));
    }
}
