package com.hackhu;

public class Question59 {
    /**
     * 题：实现一个函数，用来判断一棵二叉树是不是对称的
     * 解题思路：将判断一棵二叉树是否对称转换为判断左右两棵子树是否相等
     * 即左右两树的结点个数相等，当前结点相等，tree1 左子树与 tree2 右子树相等，tree1 右子树与 tree2 左子树相等
     *
     * @param root
     * @return
     */
    public boolean isSymmetrical(BinaryTree root) {
        if (root == null) {
            return false;
        }
        return isSymmetrical(root.left, root.right);
    }

    public boolean isSymmetrical(BinaryTree tree1, BinaryTree tree2) {
        if (tree1 == null && tree2 == null) { // 结点个数一致，且之前结点都相等，返回 true
            return true;
        }
        if (tree1 == null || tree2 == null || tree1.val != tree2.val) { // 结点数量不一致\当前结点不相等，返回 false
            return false;
        }
        return isSymmetrical(tree1.left, tree2.right) && isSymmetrical(tree1.right, tree2.left); // 对称比较两树的左右节点
    }

    public static void main(String[] args) {
        BinaryTree tree3 = new BinaryTree(3, null, null);
        BinaryTree tree4 = new BinaryTree(4, null, null);
        BinaryTree tree2 = new BinaryTree(2, tree3, tree4);
        BinaryTree tree22 = new BinaryTree(2, tree4, tree3);
        BinaryTree tree1 = new BinaryTree(1, tree2, tree22);
        Question59 q = new Question59();
        System.out.println(q.isSymmetrical(tree1));
    }
}
