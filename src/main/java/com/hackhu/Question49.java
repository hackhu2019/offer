package com.hackhu;
enum State{
    YES,NO
}
public class Question49 {


    /**
     * 题：将字符串转换为整数
     * 思路：用枚举类型标记输入字符串是否为数字，YES 为是，NO 表示不是，非数字字符串，更改 state 返回 0
     * 1、判断字符串是否有效，非空
     * 2、过滤数字开头的
     * @param str
     * @return
     */
    static State state = State.YES; // 标记字符串合法性,也可以通过声明异常来标识
    public int strToInt(String str){
        if (str == null || str.length() < 1) {
            state = State.NO;
            return 0;
        }
        int index = 0;
        long num = 0;
        boolean symbol = true; // 标记正负号
        if (str.charAt(index)=='+'||str.charAt(index)=='-') { // 过滤正负号
            symbol = str.charAt(index) == '+' ? true : false;
            index++;
        }
        if (index == str.length()) { // 过滤只有正负号情况
            state = State.NO;
            return 0;
        }
        while (index < str.length()) {
            char c = str.charAt(index);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
                index++;
            } else {
                state = State.NO;
                return 0;
            }
            if ((symbol && num > Integer.MAX_VALUE) || (!symbol && num < Integer.MIN_VALUE)) { // 处理溢出问题
                state = State.NO;
                return 0;
            }
        }
        return (int) (symbol ? num : -num); // 根据正负号发挥相应数字
    }

    public static void main(String[] args) {
        Question49 q = new Question49();
        String str = "-1222222222";
        int num = q.strToInt(str);
        if (state == State.YES) {
            System.out.println("输入字符串可转换为 Int 型整数：" + num);
        } else {
            System.out.println("输入字符串无法转换为 Int 型整数");
        }
    }
}
