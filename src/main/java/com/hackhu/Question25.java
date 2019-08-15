package com.hackhu;

import java.util.Stack;

public class Question25 {
    /**
     * 问题：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径
     * 路径：从根节点到叶节点所经过的结点连起来形成路径
     * 思路：回溯法、深度优先遍历、前序遍历
     * 每遍历一节点，将其压栈，计算栈内元素和，若为目标值，返回，输出栈内元素
     * 大于目标值，元素出栈，不输出栈内序列
     * 小于目标值，继续遍历下一层节点
     * @param root
     * @param target
     */
    Stack<BinaryTree> stack = new Stack<>();
    public void findPath(BinaryTree root,int target){
        if (root == null) {
            return;
        }
        findTarget(root, target);
    }

    public void findTarget(BinaryTree tree, int target) {
        if (tree == null) {
            return;
        }
        if (tree.left==null&&tree.right==null&&tree.val == target) { // 遍历至叶节点，找到目标值，输出路径，返回
            System.out.print(target+" ");
            for (BinaryTree binaryTree : stack) { // 将
                System.out.print(binaryTree.val+" ");
            }
            System.out.println("");
            return;
        }
        if (tree.val > target) {
            return;
        } else {
            stack.push(tree);
            target -= tree.val;
            findPath(tree.left, target);
            findPath(tree.right, target);
            stack.pop(); // 遍历完当前路径，清除该路径节点
        }
    }

    public static void main(String[] args) {
        Question25 question25 = new Question25();
        BinaryTree left1 = new BinaryTree(4, null, null);
        BinaryTree left2 = new BinaryTree(7, null, null);
        BinaryTree left = new BinaryTree(5, left1, left2);
        BinaryTree right = new BinaryTree(12, null, null);
        BinaryTree root = new BinaryTree(10, left, right);
        question25.findPath(root,22);
    }
}
