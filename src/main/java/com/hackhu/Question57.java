package com.hackhu;

public class Question57 {
    /**
     * 题：删除链表中的重复结点.(1->2->3->3->4->4->5 删除后为 1->2->5)
     * 使用哨兵结点，当前结点的下一节点与下一节点值相同时，当前结点指向下一个非重复结点
     * @param node
     */
    public Node deleteDuplication(Node node){
        if (node == null) {
            return null;
        }
        Node head = new Node(0, node), p;
        p= head;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                while (p.next.next != null&&p.next.val == p.next.next.val) { // 删除多个重复项
                    p.next = p.next.next;
                }
                p.next = p.next.next; // 指向下一个与当前结点非重复结点
            } else { // 无重复，遍历下一结点
                p = p.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node node11 = new Node(5,null);
        Node node1 = new Node(4,node11);
        Node node2 = new Node(4,node1);
        Node node3 = new Node(3,node2);
        Node node4 = new Node(3,node3);
        Node node5 = new Node(2,node4);
        Node node6 = new Node(1,node5);
        Node node7 = new Node(1,node6);
        Node node = node7;
        Question57 q = new Question57();
        node = q.deleteDuplication(node);
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }
}
