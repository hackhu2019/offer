package com.hackhu;

public class Question21 {
    /**
     * 题目：实现一个包含 min 函数（找到栈中的最小值）的栈，要求 push 、 pop 、min 的操作都为 O(1) 的时间复杂度
     * 思路：使用单链表来模拟栈，建立哨兵节点方便插入删除
     * push 在联表头节点插入
     * pop 返回头节点值，删除头节点
     * min 辅助栈存储，按照升序将新节点插入辅助栈
     */
    public class StackWithMin{
        Node head = new Node(0);
        Node support = new Node(0);

        public StackWithMin() {
            head.next = null;
            support.next = null;
        }

        /**
         * 头节点插入新元素
         * @param val
         */
        public void push(int val) {
            Node node = new Node(val);
            node.next = head.next;
            head.next = node;
            // 当辅助栈为空或插入元素小于辅助栈栈顶，则直接在辅助栈栈顶插入
            if (support.next == null||support.next.val>val) {
                Node temp = new Node(val);
                temp.next = support.next;
                support.next = temp;
            }
        }


        public Node pop() throws Exception {
            if (head.next == null) {
                throw new Exception("栈内元素为空，无法出栈");
            }
            Node node = head.next;
            // 最小值元素被移除出栈
            if (support.next!=null&&node.val == support.next.val) {
                support.next = support.next.next;
            }
            head = head.next;
            return node;
        }
        // 返回最小值辅助栈栈顶元素
        public Node min() throws Exception {
            if (head.next == null) {
                throw new Exception("栈内元素为空，无最小值");
            }
            // 若栈内元素不为空，辅助元素为空，出发一次最小值查找
            if (support.next == null) {
                Node p = head.next;
                Node temp = new Node(p.val);
                p = p.next;
                while (p != null) {
                    if (p.val < temp.val) {
                        temp.val = p.val;
                    }
                    p = p.next;
                }
                temp.next = support.next;
                support.next = temp;
            }
            return support.next;
        }
    }

    public static void main(String[] args) throws Exception {
        Question21.StackWithMin node = new Question21().new StackWithMin();
        node.push(3);
        node.push(2);
        node.push(1);
        System.out.println("当前最小值为:"+node.min().val);
        System.out.println(node.pop().val);
        System.out.println("当前最小值为:"+node.min().val);
        System.out.println(node.pop().val);
        System.out.println("当前最小值为:"+node.min().val);
        System.out.println(node.pop().val);
    }
}
