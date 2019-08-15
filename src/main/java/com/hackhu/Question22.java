package com.hackhu;

import java.util.Stack;

public class Question22 {
    /**
     * 问题：给定数组为压栈顺序（无重复），判断另一数组是否可能为出栈顺序
     * 思路：建立一个辅助栈，依序遍历压栈序列，若与出栈数不相等，则将该压栈数压入辅助栈，继续遍历压栈数组
     * 若相等则继续遍历入栈序列和出栈序列，当出栈序列与入栈序列和辅助栈序列都不一致时，返回 false
     * 若辅助栈空，且入栈序列遍历完毕则返回 true
     * @param pushOrder
     * @param popOrder
     * @return
     */
    public boolean isPopOrder(int[] pushOrder,int[] popOrder){
        // 出栈、入栈序列为空或长度不相等，则返回 false
        if (pushOrder == null || popOrder == null||pushOrder.length!=popOrder.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0,
                popIndex = 0,
                len=pushOrder.length;
        while (popIndex < len) {
            if (pushIndex<len&&pushOrder[pushIndex] == popOrder[popIndex]) { // 入栈出栈序列一致，继续遍历下一个
                popIndex++;
                pushIndex++;
            }
            // 辅助栈顺序与出栈序列一致，辅助栈出栈，继续遍历下一个
            else if (stack.size() != 0 && stack.peek() == popOrder[popIndex]) {
                popIndex++;
                stack.pop();
            }
            // 入栈序列遍历结束且辅助栈顺序与出栈序列不一致，直接返回 false
            else if (pushIndex >= len && stack.peek() != popOrder[popIndex]) {
                return false;
            }
            // 压入辅助装，继续寻找下一相同序列
            else {
                stack.push(pushOrder[pushIndex]);
                pushIndex++;
            }
        }
        return stack.size()==0&&pushIndex==len; // 当序列一致时，辅助栈为空，入栈序列遍历完成
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 3, 5, 1, 2};
        Question22 question22 = new Question22();
        System.out.println(question22.isPopOrder(push,pop));
    }
}
