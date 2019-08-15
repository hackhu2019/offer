package com.hackhu;

public class Question54 {
    /**
     * 题：实现一个函数来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100"、"5e2"、"-123"、“3.1416”即"-1E-16" 都表示数值
     * 而 "12e"、"1a3.14"、"1.2.3"、"+-5" 以及 "12e+5.4" 都不是
     * 思路分析：
     * 可以将数值匹配看成 3 个部分：整数部分、小数部分、科学计数部分，遍历字符串，对不同部分分别处理
     * 连续出现两个加减号或数字后跟着加减号、出现 e\E 以外的字符，多个小数点、E 后面出现小数点，都不满足数值情况
     * @param num
     * @return
     */
    public boolean isNumeric(String num){
        if (num == null) {
            return false;
        }
        boolean result = true;
        int index = 0;
        if (num.charAt(index) == '+' || num.charAt(index) == '-') { // 过滤加减号
            index++;
        }
        if (index==num.length()||!(num.charAt(index) < '9' && num.charAt(index) > '0')) { // 加减号后为非数字，则返回 true
            return false;
        }
        while (index < num.length()) {
            if (num.charAt(index) == '.') { // 检测小数部分是否正确
                index++;
                result = index != scanDigital(num, index); // 点号后为非数字，result 设置为 false
                index = scanDigital(num, index);
                if (index < num.length() && num.charAt(index)=='.') { // 过滤多个小数点
                    return false;
                }
            } else if ((num.charAt(index) < '9' && num.charAt(index) > '0')) {
                index = scanDigital(num, index); // 过滤数字
            } else if (num.charAt(index) == 'E' || num.charAt(index) == 'e') { // 检测科学计数部分是否正确
                index++;
                if (index == num.length()||
                        num.charAt(index)=='.'||
                        num.charAt(index)=='E'||
                        num.charAt(index)=='e') {
                    return false;
                }
                if (num.charAt(index) == '+' || num.charAt(index) == '-') { // 过滤科学计数法 +- 符号
                    index++;
                }
                result = index != scanDigital(num, index);
                index = scanDigital(num, index);
            } else {
                return false;
            }
        }
        return result; // 匹配成功返回 true
    }
    private int scanDigital(String num,int index){ // 过滤数字
        while (index < num.length() && (num.charAt(index) < '9' && num.charAt(index) > '0')) {
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        Question54 q = new Question54();
        System.out.println(q.isNumeric("+.1"));
    }
}
