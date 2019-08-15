package com.hackhu;

public class Question53 {
    /**
     * 题：实现一个函数用来匹配包含 '.' 和 '*' 的正则表达式。
     * 模式串中的字符 '.' 表示匹配任意字符，而 '*' 表示它前面的字符可以出现任意次（含 0 次）。
     * 思路，回溯、剪枝，对于 '*' 匹配多个字符，任意一种情况成功都认为成功
     * @param str
     * @param regx
     * @return
     */
    public boolean match(String str,String regx) {
        if (str == null || regx == null) {
            return false;
        }
        return match(str, 0, regx, 0);
    }

    /**
     * 当二者都遍历结束，说明匹配成功返回 true
     * 只有一个遍历结束则说明匹配不成功，返回 false
     * 先判断当前匹配字符下一个字符是否为 '*' 是匹配 0~n 个与当前字符相同字符
     * 当前字符为 '.' 或字符相等，则匹配下一个字符
     * 都不满足，返回false
     * @param str
     * @param strIndex
     * @param regx
     * @param regxIndex
     * @return
     */
    private boolean match(String str,int strIndex,String regx,int regxIndex){
        if (strIndex == str.length() && regxIndex == regx.length()) {
            return true;
        }
        if (strIndex == str.length() || regxIndex == regx.length()) {
            return false;
        }
        if (regxIndex+1<regx.length() && regx.charAt(regxIndex + 1) == '*') {
            // 匹配 0~n 个字符
            if (regx.charAt(regxIndex) == '.'||regx.charAt(regxIndex) == str.charAt(strIndex)) {
                for (int i = strIndex; i < str.length(); i++) {
                    if (match(str, i, regx, regxIndex + 2)) {
                        return true;
                    }
                }
            }
            return match(str, strIndex , regx, regxIndex + 2);
        } else if (regx.charAt(regxIndex) == '.' || regx.charAt(regxIndex) == str.charAt(strIndex)) {
            // 匹配单个字符
            return match(str, strIndex + 1, regx, regxIndex + 1);
        }
        return false; // 无法匹配，返回 false
    }

    public static void main(String[] args) {
        Question53 q = new Question53();
        System.out.println(q.match("aaa","ab.a"));
    }
}
