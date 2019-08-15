package com.hackhu;

public class Question16 {
    /**
     * 题目：输入链表头结点，将该链表翻转，并返回新的头结点
     * 思路：利用哨兵结点方便对链表边界值处理
     * 特殊情况：head 为空、链表只有 1 个结点 —— 不需要翻转原路返回
     * preNode 哨兵结点，同时代表当前节点上一节点
     * curNode 当前遍历结点，也是返回的头结点
     * nextNode 下一遍历结点
     * @param head
     * @return
     */
    public Node ReverseList(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node preNode = null,
                curNode = head,
                nextNode = head.next;
        curNode.next = preNode;
        while (nextNode != null) { // 翻转链表
            preNode = curNode;
            curNode = nextNode;
            nextNode = nextNode.next; // nextNode 指向下一结点，curNode 改变 next ，指向上一节点
            curNode.next = preNode;
        }
        return curNode;
    }

    public static void main(String[] args) {
        Question16 question16 = new Question16();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        Node head = question16.ReverseList(null);
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
