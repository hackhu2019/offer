package com.hackhu;

public class Question39 {
    /**
     * 输入一棵二叉树，求二叉树的深度，即从根节点到叶节点的最长路径
     *
     * @param root
     * @return
     */
    private int depth = 0; // 记录二叉树最大深度
    public int treeDepth(BinaryTree root){
        prePrintBinaryTree(root, 0);
        return depth;
    }

    /**
     * 前序遍历二叉树，每遍历至新的一层，更新层数，若已遍历至叶节点，则比较是否大于最大深度，是则更新
     * @param node
     */
    private void prePrintBinaryTree(BinaryTree node,int count){
        if (node == null) {
            if (count > depth) {
                depth = count;
            }
            return;
        }
        prePrintBinaryTree(node.left, count + 1);
        prePrintBinaryTree(node.right,count+1);
    }

    /**
     * 判断一颗树是否为平衡二叉树，即左右子树深度差不能为大于 1
     * 先判断子树是否满足，再判断当前结点是否满足，和后序遍历顺序一致
     * @return
     */
    public boolean isBalanced(BinaryTree root) {
        if (root == null) {
            return true;
        }
        if (isBalanced(root.left) && isBalanced(root.right)) {
            return Math.abs(treeDepth(root.left) - treeDepth(root.right))<=1;
        }
        return false;
    }

    public static void main(String[] args) {
        Question39 q = new Question39();
        BinaryTree left = new BinaryTree(2,null,null);
        BinaryTree right = new BinaryTree(3,null,null);
        BinaryTree root = new BinaryTree(1, left, right);
        System.out.println(q.treeDepth(root));
    }
}
