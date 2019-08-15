package com.hackhu;

public class Question19 {
    /**
     * 输入二叉树，输出其镜像（所有的左子树变成右子树，右子树变成左子树）
     * 特殊情况，root、root.left 、 root.right 为 null，直接原路返回
     * 将root 的左右子树互换，再递归调用 mirrorOfBinaryTree
     * @param root
     * @return
     */
    public BinaryTree mirrorOfBinaryTree(BinaryTree root){
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        // 左右子树互换
        BinaryTree temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 将左右子树的子树也互换
        mirrorOfBinaryTree(root.left);
        mirrorOfBinaryTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        Question19 q = new Question19();
        BinaryTree left = new BinaryTree(1, null, null);
        BinaryTree right = new BinaryTree(3, null, null);
        BinaryTree root = new BinaryTree(2, left, right);
        System.out.print("初始顺序: ");
        root.prePrint(root);
        BinaryTree node = q.mirrorOfBinaryTree(root);
        System.out.print("\n镜像顺序: ");
        node.prePrint(node);

    }
}
