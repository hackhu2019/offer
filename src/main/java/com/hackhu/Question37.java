package com.hackhu;

import java.util.Stack;

public class Question37 {
    /**
     * 输入两个节点，找到两个节点的首个共有节点
     * 解法 1，暴力遍历， 依序遍历 list1 与 list2 任意结点是否相等，复杂度为 n*m，不推荐
     * 解法 2，正难则反，反过来看，两链表相加形状类似于 Y，从尾结点到相交的第一个结点都是一样的，我们只要反向遍历（栈）两个结点，
     * 当下一个结点不同时，当前结点就是相交的第一个结点
     * @param list1
     * @param list2
     * @return
     */
    public Node findFirstCommonNode(Node list1,Node list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        Stack<Node> stack1 = new Stack<>(); // 存储 list1 遍历顺序
        Stack<Node> stack2 = new Stack<>(); // 存储 list1 遍历顺序
        Node node1 = list1;
        Node node2 = list2;
        Node first = null;
        while (node1 != null) {
            stack1.push(node1);
            node1 = node1.next;
        }
        while (node2 != null) {
            stack2.push(node2);
            node2 = node2.next;
        }
        while (stack1.size() > 0 && stack2.size() > 0) {
            if (stack1.peek() == stack2.peek()) { // 相等继续寻找第一个相同结点
                first = stack1.pop();
                stack2.pop();
            } else { // 不相等则上一节点为第一个共有结点
                break;
            }
        }
        return first;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        Node node11 = new Node(11);
        node11.next = node2;
        Question37 q = new Question37();
        Node node = q.findFirstCommonNode(node1, node11);
        System.out.println(node);
    }
}
