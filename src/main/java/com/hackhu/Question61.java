package com.hackhu;

import java.util.LinkedList;
import java.util.Stack;

public class Question61 {
    /**
     * 题：实现一个函数，按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，以此类推
     * 思路分析：利用两个栈来存储要打印的结点。当前层为奇数层，从栈1中打印，下一层结点加入栈2。
     * 当前层为偶数层，从栈中打印结点，下一层结点加入 栈2
     * @param root
     */
    public void print(BinaryTree root) {
        if (root == null) {
            return;
        }
        boolean flag = true; // 标志当前是奇数层还是偶数层
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        stack1.add(root);
        while (stack1.size() > 0 || stack2.size() > 0) {
            if (flag) {
                // 奇数层，下一层结点加入 stack2 先加左节点再加右结点
                while (stack1.size() > 0) {
                    BinaryTree temp = stack1.pop();
                    System.out.print(temp.val+" ");
                    if (temp.left != null) {
                        stack2.push(temp.left);
                    }
                    if (temp.right != null) {
                        stack2.push(temp.right);
                    }
                }
            } else {
                // 偶数层，先加右子结点，再加左子结点
                while (stack2.size() > 0) {
                    BinaryTree temp = stack2.pop();
                    System.out.print(temp.val+" ");
                    if (temp.right != null) {
                        stack1.push(temp.right);
                    }
                    if (temp.left != null) {
                        stack1.push(temp.left);
                    }
                }
            }
            System.out.println("");
            flag = !flag; // 标记下一层
        }
    }

    public static void main(String[] args) {
        Question61 q = new Question61();
        BinaryTree tree15 = new BinaryTree(15,null,null);
        BinaryTree tree14 = new BinaryTree(14,null,null);
        BinaryTree tree13 = new BinaryTree(13,null,null);
        BinaryTree tree12 = new BinaryTree(12,null,null);
        BinaryTree tree11 = new BinaryTree(11,null,null);
        BinaryTree tree10 = new BinaryTree(10,null,null);
        BinaryTree tree9 = new BinaryTree(9,null,null);
        BinaryTree tree8 = new BinaryTree(8,null,null);
        BinaryTree tree7 = new BinaryTree(7,tree14,tree15);
        BinaryTree tree6 = new BinaryTree(6,tree12,tree13);
        BinaryTree tree5 = new BinaryTree(5,tree10,tree11);
        BinaryTree tree4 = new BinaryTree(4,tree8,tree9);
        BinaryTree tree3 = new BinaryTree(3,tree6,tree7);
        BinaryTree tree2 = new BinaryTree(2,tree4,tree5);
        BinaryTree tree1 = new BinaryTree(1,tree2,tree3);
        q.print(tree1);
    }
}
