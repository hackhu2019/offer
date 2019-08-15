package com.hackhu;

public class Question63 {
    /**
     * 题：给定一颗二叉搜索树，找出其中第 K 个的结点
     * 根据二叉搜索树的特性，中序遍历的第 K 个结点就是答案
     * @param root
     * @param k
     * @return
     */
    BinaryTree result = null; // 全局变量，存储查找结果
    int k = 0; // 计算当前次序
    public BinaryTree KthNode(BinaryTree root,int k){
        if (root == null) {
            return result;
        }
        this.k = k;
        KthNode(root);
        return result;
    }
    private void KthNode(BinaryTree root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            KthNode(root.left);
        }
        if (result == null) {
            if (k == 1) {
                result = root;
                return;
            }
            k--;
            if (root.right != null) {
                KthNode(root.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree2 = new BinaryTree(2, null, null);
        BinaryTree tree4 = new BinaryTree(4, null, null);
        BinaryTree tree3 = new BinaryTree(3, tree2, tree4);
        BinaryTree tree6 = new BinaryTree(6, null, null);
        BinaryTree tree8 = new BinaryTree(8, null, null);
        BinaryTree tree7 = new BinaryTree(7, tree6, tree8);
        BinaryTree tree5 = new BinaryTree(5, tree3, tree7);
        Question63 q = new Question63();
        BinaryTree tree = q.KthNode(tree5, 3);
        tree.prePrint(tree);
    }
}
