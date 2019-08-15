package com.hackhu;

public class Question6 {
    /**
     * 重建二叉树
     * 根据前序遍历数组和中序便利数组重建新的二叉树
     * 前序遍历先遍历根节点，中序遍历先遍历左节点
     * 则前序数组遍历 1个，中序数组寻找改值所在的位置，该位置左边的都为左子树，右边的都为右子树
     * 左子树的根节点、右子树的根节点分别为上一节点的左右节点
     * 当中序数组中查找到的位置为数组起始点，则左子树为 null，
     * 查找到的位置为数组末端，则右子树为 null，
     * @param pre
     * @param mid
     * @return
     */
    public BinaryTree reBuilder(int[] pre,int[] mid,int preStart,int preEnd,int midStart,int midEnd){
        if (preStart >= preEnd || midStart >= midEnd) {
            return null;
        }
        int rootIndex = 0;
        // 在中序遍历中找到对应的根节点位置
        for (int i = midStart; i < midEnd; i++) {
            if (mid[i] == pre[preStart]) {
                rootIndex = i;
                break;
            }
        }
        BinaryTree root = new BinaryTree(pre[preStart], null, null);
        int leftRang = rootIndex - midStart; // 左子树范围
        // 中序遍历中中节点的左边都是左子树，右边都是右子树，同样前序遍历中当前点后
        root.left = reBuilder(pre, mid, preStart + 1, preStart+leftRang+1, midStart, rootIndex);
        root.right = reBuilder(pre, mid, preStart + leftRang + 1, preEnd, rootIndex + 1, midEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};
        Question6 question = new Question6();
        BinaryTree root = new BinaryTree();
        root.prePrint(question.reBuilder(pre,mid,0,pre.length,0,mid.length));
    }
}
