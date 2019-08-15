package com.hackhu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question60 {
    /**
     * 题：从上到下按层打印二叉树，同层结点按照从左到右的顺序打印，每一层打印到一行
     * 思路：广度优先遍历，记录当前层与下一层结点数
     * @param root
     */
    public void print(BinaryTree root){
        if (root == null) {
            return;
        }
        int curCount = 0, nextCount = 0;
        LinkedList<BinaryTree> list = new LinkedList<>();
        list.add(root);
        nextCount = 1;
        while (list.size() > 0) {
            curCount = nextCount;
            nextCount = 0;
            while (curCount > 0) { // 打印当前层结点，将下一层结点加入队列，计算下一层结点个数
                BinaryTree cur = list.poll();
                System.out.print(cur.val+" ");
                if (cur.left != null) {
                    list.add(cur.left);
                    nextCount++;
                }
                if (cur.right != null) {
                    list.add(cur.right);
                    nextCount++;
                }
                curCount--;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree5 = new BinaryTree(5, null, null);
        BinaryTree tree7 = new BinaryTree(7, null, null);
        BinaryTree tree6 = new BinaryTree(6, tree5, tree7);
        BinaryTree tree9 = new BinaryTree(9, null, null);
        BinaryTree tree11 = new BinaryTree(11, null, null);
        BinaryTree tree10 = new BinaryTree(10, tree9, tree11);
        BinaryTree tree8 = new BinaryTree(8, tree6, tree10);
        Question60 q = new Question60();
        q.print(tree8);
    }
}
