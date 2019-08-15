package com.hackhu;

import java.util.Stack;

class Node{
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
public class Question5 {
    /**
     * 递归法打印所有节点信息
     * 存在问题：链表过长，递归层数过多，超出栈顶
     * @param head
     */
    public void printNode(Node head){
        if (head == null) {
            return;
        }
        printNode(head.next);
        System.out.println(head.val);
    }

    /**
     * 创建一个新链表，每遍历一个非空节点，则在新链表一个同值的新节点
     * @param head
     */
    public void printNodePlus(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (stack.size()!=0) {
            System.out.println(stack.pop().val);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        Question5 question = new Question5();
        question.printNodePlus(node1);
    }
}


