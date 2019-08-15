package com.hackhu;

import java.util.Deque;
import java.util.LinkedList;

public class Question23 {
    /**
     * 问题：如何按照从上到下顺序打印二叉树（即：广度优先遍历），同一层节点按照从左到右顺序
     * 建立一个队列，当 root 不为空时将其加入队列，
     * 建立循环，当队列不为空，执行出队，并打印其值
     * 左右节点不为空则将其入队
     * @param root
     */
    public void printBinaryFromTopToBottom(BinaryTree root) {
        if (root == null) {
            return;
        }
        Deque<BinaryTree> deque = new LinkedList<>();
        deque.push(root);
        while (deque.size() > 0) {
            BinaryTree temp = deque.pop(); // 出队
            System.out.print(temp.val+" ");
            if (temp.left != null) { // 入队
                deque.add(temp.left);
            }
            if (temp.right != null) {
                deque.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree left1 = new BinaryTree(4, null, null);
        BinaryTree left2 = new BinaryTree(5, null, null);
        BinaryTree left = new BinaryTree(1, left1, left2);
        BinaryTree right = new BinaryTree(3, null, null);
        BinaryTree root = new BinaryTree(2, left, right);
        Question23 q = new Question23();
        q.printBinaryFromTopToBottom(null);
    }
}
