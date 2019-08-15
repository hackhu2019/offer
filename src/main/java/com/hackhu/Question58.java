package com.hackhu;

public class Question58 {
    /**
     * 题：给定一棵二叉树其中的一个结点，找出中序遍历顺序的下一个结点。
     * 二叉树中的结点除了有两个分别指向左右子节点的指针外，还有一个指向父结点的指针
     * 中序遍历特点：先遍历左子结点，再遍历当前结点，再遍历右子结点
     * 首先判断当前结点的右子结点是否存在，存在则返回其最左子结点，若左子节点也不存在则返回该右子结点
     * 若无右子结点，则判断当前结点是否为父节点的左子节点，下一结点为父节点
     * 否则判断父节点的父节点
     * @param node
     * @return
     */
    public BinaryTree getNext(BinaryTree node) {
        BinaryTree next = null;
        if (node.right != null) {
            if (node.right.left != null) {
                BinaryTree temp = node.right.left;
                while (temp.left != null) { // 找到右子树的最左子结点
                    temp = temp.left;
                }
                next = temp;
            } else { // 左子结点不存在，返回当前结点
                next = node.right;
            }
        } else {
            BinaryTree root = node.root;

            // 子树遍历完成，找到当前结点为左子树时对应的父节点
            while (root != null && root.left != node) {
                node = root;
                root = root.root;
            }
            next = root; // 当前结点为父节点的左子节点，下一结点为父节点
        }
        return next;
    }

    public static void main(String[] args) {
        BinaryTree tree9 = new BinaryTree(9, null, null);
        BinaryTree tree8 = new BinaryTree(8, null, null);
        BinaryTree tree7 = new BinaryTree(7, null, null);
        BinaryTree tree6 = new BinaryTree(6,null, null);
        BinaryTree tree5 = new BinaryTree(5, tree8, tree9);
        BinaryTree tree4 = new BinaryTree(4, null, null);
        BinaryTree tree3 = new BinaryTree(3, tree6, tree7);
        BinaryTree tree2 = new BinaryTree(2, tree4, tree5);
        BinaryTree tree1 = new BinaryTree(1, tree2, tree3,null);
        tree9.root = tree5;
        tree8.root = tree5;
        tree7.root = tree3;
        tree6.root = tree3;
        tree5.root = tree2;
        tree4.root = tree2;
        tree3.root = tree1;
        tree2.root = tree1;
        Question58 q = new Question58();
        System.out.println(q.getNext(tree9
        ));
    }
}
