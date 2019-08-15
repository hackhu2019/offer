package com.hackhu;

import java.util.Stack;

class Queue<T>{
    Stack<T> stack1 = new Stack<>();
    Stack<T> stack2 = new Stack<>();
    public void pushHead(T ob){
        stack1.push(ob);;
    }
    public T popHead() throws Exception {
        if (stack1.size() == 0) {
            throw new  Exception("队列为空无法出栈");
        }
        while (stack1.size() != 1) {
            stack2.push(stack1.pop());
        }
        T ob = stack1.pop(); // 存储队首元素
        while (stack2.size() != 0) { // 将栈恢复原样
            stack1.push(stack2.pop());
        }
        return ob;
    }
}
public class Question7 {
}
