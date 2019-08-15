package com.hackhu;

public class BinaryTree {
    int val;
    BinaryTree left;
    BinaryTree right;
    BinaryTree root; // 父节点

    public BinaryTree() {
    }

    public BinaryTree(int val, BinaryTree left, BinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public BinaryTree(int val, BinaryTree left, BinaryTree right, BinaryTree root) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.root = root;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "val=" + val +
                '}';
    }

    /**
     * 前序遍历二叉树，先打印根节点再打印左子树最后打印右子树
     * @param root
     */
    public void prePrint(BinaryTree root){
        if (root==null) {
            return;
        }
        System.out.print(root.val+" ");
        prePrint(root.left);
        prePrint(root.right);
    }

    /**
     * 中序遍历，先打印左子树，再打印根节点，最后打印右子树
     * @param root
     */
    public void midPrint(BinaryTree root){
        if (root == null) {
            return;
        }
        midPrint(root.left);
        System.out.print(root.val+" ");
        midPrint(root.right);
    }

    /**
     * 后序遍历，先打印左子树，再打印右子树，最后打印根节点
     * @param root
     */
    public void nextPrint(BinaryTree root){
        if (root == null) {
            return;
        }
        nextPrint(root.left);
        nextPrint(root.right);
        System.out.print(root.val+" ");
    }
    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree(4, null, null);
        BinaryTree tree2 = new BinaryTree(8, null, null);
        BinaryTree tree3 = new BinaryTree(12, null, null);
        BinaryTree tree4 = new BinaryTree(16, null, null);
        BinaryTree tree5 = new BinaryTree(6, tree1, tree2);
        BinaryTree tree6 = new BinaryTree(14, tree3, tree4);
        BinaryTree tree7 = new BinaryTree(10, tree5, tree6);
        tree1.prePrint(tree7);
        System.out.println("\n--------------------------------");
        tree1.midPrint(tree7);
        System.out.println("\n--------------------------------");
        tree1.nextPrint(tree7);
    }
}
