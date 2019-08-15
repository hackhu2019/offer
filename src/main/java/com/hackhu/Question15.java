package com.hackhu;

public class Question15 {
    /**
     * 输出链表倒数第 K 个结点
     * 特殊情况，链表为空，或不足 K 个节点，返回 NULL
     * 使用快慢指针，快指针比慢指针快 K 个节点，当快指针的下一结点为 NULL 时，慢指针的下一节点为要删除结点
     * @param head
     * @return
     */
    public Node findKToTail(Node head,int k) {
        if (head == null) {
            return null;
        }
        Node fast = head, slow = fast;
        while (k > 0) {
            if (fast == null) { // 不足 K 个节点，返回 NULL
                return null;
            }
            k--;
            fast = fast.next;
        }
        while (fast!= null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        Question15 q = new Question15();
        System.out.println(q.findKToTail(node1,-1));
    }
}
