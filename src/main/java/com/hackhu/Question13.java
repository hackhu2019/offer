package com.hackhu;

public class Question13 {
    /**
     * 删除链表中指定值为 target 的节点
     * 特殊情况，head 为 null
     * 则直接原路返回
     * 使用哨兵节点，辅助完成
     * @param head
     * @param target
     */
    public Node deleteNode(Node head, int target) {
        Node node = new Node(0); // 哨兵结点，方便删除
        Node p = head;
        Node newHead = node;
        node.next = p;
        while (p!=null&&p.val != target) {
            p = p.next;
            node = node.next;
        }
        // 特殊情况，target 点不在链表中，则没有要删除的结点
        if (p != null) {
            node.next = p.next; // 删除找到的节点
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        Question13 question13 = new Question13();
        Node head = node1;
        head=question13.deleteNode(head, 5);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
