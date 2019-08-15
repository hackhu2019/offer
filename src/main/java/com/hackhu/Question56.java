package com.hackhu;

public class Question56 {
    /**
     * 题：一个链表中包含还，找出环的入口结点
     * 解题思路：结合快慢指针找到链表环路中的任意结点，该结点向后前进 N 步，得出环的长度，再结合「链表的倒数第 N 个结点」,
     * 慢指针指向头结点，快指针调整为头结点后的第 N 个结点，当两指针相遇时，该结点为环的入口结点
     * @param head
     * @return
     */
    public Node meetingNode(Node head){
        if (head == null || head.next == null) {
            return null;
        }
        Node low = head, fast = low.next.next;
        int circleLong = 1; // 环长度

        // 找到任意环结点
        while (low != fast) { // 题目中必然存在环，忽略空指针判断
            low = low.next;
            fast = fast.next.next; // 快指针两倍速前进
        }
        Node temp = low.next;

        // 统计环长度
        while (temp != low) {
            temp = temp.next;
            circleLong++;
        }

        low=head;
        fast = low;

        // 快指针调整为头结点后的第 N 个结点
        while (circleLong > 0) {
            fast = fast.next;
            circleLong--;
        }

        // 快慢指针相交点为入口结点
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }

    public static void main(String[] args) {
        Question56 q = new Question56();
        Node node1 = new Node(1);
        Node node2 = new Node(2,node1);
        Node node3 = new Node(3,node2);
        Node node4 = new Node(4,node3);
        Node node5 = new Node(5,node4);
        Node node6 = new Node(6,node5);
        node1.next = node3;
        System.out.println(q.meetingNode(node6));
    }
}
