package com.hackhu;

public class Question17 {
    /**
     * 合并两条升序链表，返回新的升序链表
     * 特殊情况: 两条链表中有 1 条链表为空，则直接返回另一条链表
     * 思路：回溯递归解题，判断两条链表中当前更小值，他们的下一节点，也是当前更小值，直到有一条链表为空，则返回
     * @param list1
     * @param list2
     * @return
     */
    public Node mergeTwoList(Node list1,Node list2){
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        Node p = list1.val > list2.val ? list2 : list1; // 指针 p 指向当前最小值节点
        if (list1.val > list2.val) {
            p.next = mergeTwoList(list1, list2.next);
        } else {
            p.next = mergeTwoList(list1.next, list2);
        }
        return p;
    }

    public static void main(String[] args) {
        Question17 question17 = new Question17();
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        Node node4 = new Node(2);
        Node node5 = new Node(4);
        Node node6 = new Node(6);
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        Node head = question17.mergeTwoList(null, node4);
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
