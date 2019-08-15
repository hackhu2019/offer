package com.hackhu;

public class Question18 {
    /**
     * 输入主树与子树，判断 subRoot 是否为 root 的字串
     * 特殊情况：root、subRoot 为 null 则直接返回 false
     * 当 root 与 subRoot val 相等时，只需要判断二者的遍历是否一致即可
     * 不相等时，继续判断是否与左子树、右子树相等
     * @param root
     * @param subRoot
     * @return
     */
    public boolean hasSubTree(BinaryTree root, BinaryTree subRoot) {
        boolean result = false;
        if (root != null && subRoot != null) {
            if (root.val == subRoot.val) {
                result=tree1HasTree2(root, subRoot);
            }
            if (!result) {
                result = hasSubTree(root.left, subRoot);
            }
            if (!result) {
                result = hasSubTree(root.right, subRoot);
            }
        }
        return result;
    }

    /**
     * 判断 tree2 是与 tree1 输出一致
     * 若 tree2 为空，则 tree1 包含 tree2
     * 若 tree1 为空，tree2 不为空，则 tree1 不包含 tree2
     * tree1、tree2 都不为空，且值一致，则比较左右子树是否一致
     * 一致，返回 true，不一致返回 false
     * @param tree1
     * @param tree2
     * @return
     */
    private boolean tree1HasTree2(BinaryTree tree1, BinaryTree tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree1.val != tree2.val) {
            return false;
        }

        return tree1HasTree2(tree1.left,tree2.left)&&tree1HasTree2(tree1.right,tree2.right);
    }

    public static void main(String[] args) {
        BinaryTree left = new BinaryTree(1, null, null);
        BinaryTree right = new BinaryTree(3, null, null);
        BinaryTree root = new BinaryTree(2, left, right);
        Question18 question18 = new Question18();
        System.out.println(question18.hasSubTree(right,left));
    }
}
