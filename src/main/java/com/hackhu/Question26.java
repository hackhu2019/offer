package com.hackhu;

class ComplexNode {
    int val;
    ComplexNode next; // 链表下一结点
    ComplexNode sibling; // 指向任意节点或 null

    public ComplexNode() {
    }

    public ComplexNode(int val, ComplexNode next, ComplexNode sibling) {
        this.val = val;
        this.next = next;
        this.sibling = sibling;
    }

    @Override
    public String toString() {
        return "ComplexNode{" +
                "val=" + val +
                ", next=" + next +
                ", sibling=" + sibling +
                '}';
    }
}

public class Question26 {
    /**
     * 复制一个复杂链表，ComplexNode 的 可能指向任意结点或 null
     * 第一次遍历复杂链表，将其节点全部复制一份，插入当前结点后
     * 第二次遍历链表，将偶数结点的 sibling 都指向其节点的下一结点（复制完成）
     * 将原链表与复制链表分离，返回复制链表
     * @param head
     * @return
     */
    public ComplexNode copyComplexNode(ComplexNode head) {
        // 复制所有的非空结点在节点后插入
        ComplexNode node = head;
        while (node != null) {
            ComplexNode temp = new ComplexNode();
            temp.val = node.val;
            temp.next = node.next;
            temp.sibling = node.sibling;
            node.next = temp;
            node = temp.next;
        }
        // 将偶数节点的 sibling 都指向其节点的下一结点（复制完成）
        node = head.next;
        while (node != null&&node.next!=null) { // 奇数偶数节点都指向一个空节点
            if (node.sibling != null) {
                node.sibling = node.sibling.next;
            }
            node = node.next.next;
        }

        // 将原链表与复制链表分离，返回复制链表
        node = head.next;
        ComplexNode odd = head; // 串联奇数链表（原链表）
        ComplexNode even = node; // 串联偶数链表（被复制链表）
        while (odd != null&&even.next!=null) { // 奇数偶数节点都指向一个空节点
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ComplexNode node1 = new ComplexNode(1, null, null);
        ComplexNode node2 = new ComplexNode(2, node1, null);
        ComplexNode node3 = new ComplexNode(3, node2, node1);
        Question26 q = new Question26();
        ComplexNode c = q.copyComplexNode(node3);
        while (c != null) {
            System.out.println(c);
            c = c.next;
        }
    }
}
