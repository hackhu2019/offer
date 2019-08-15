package com.hackhu;

public class Question27 {
    /**
     * 输入一棵二叉搜索树将其转换为排序的链表。不能创建任何任何新的节点，只能转变后的双向链表。
     * 转换后的顺序与二叉树的中序遍历顺序一致
     * left 指向上一节点、right 指向下一节点
     * 按照中序遍历顺序遍历，
     * @param tree
     * @return
     */
    public BinaryTree convert(BinaryTree tree){
        convertNode(tree,null);
        BinaryTree head = tree;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    /**
     * left 指向子节点，右节点指向父节点
     * 当 node 左节点为空，则 left 指向 null
     * 若 node.left 不为空，则上一节点为子树排序后末尾节点
     * lastNode 不为空，则 lastNode 右节点指回 node
     * node.right 不为空，则 node.right 为下一遍历节点
     * @param node
     * @param lastNode
     */
    public BinaryTree convertNode(BinaryTree node,BinaryTree lastNode){
        if (node == null) {
            return null;
        }
        BinaryTree current = node;
        if (current.left != null) {
            lastNode= convertNode(current.left,lastNode);
        }
        current.left = lastNode;
        if (lastNode != null) {
            lastNode.right = current;
        }
        lastNode = current;
        if (current.right != null) {
            lastNode=convertNode(current.right,lastNode);
        }
        return lastNode;
    }

    public static void main(String[] args) {
        Question27 q = new Question27();
        BinaryTree node1 = new BinaryTree(1, null, null);
        BinaryTree node2 = new BinaryTree(2, null, null);
        BinaryTree node3 = new BinaryTree(3, node1, node2);
        BinaryTree head = q.convert(node3);
        while (head != null) {
            System.out.println(head.val);
            head = head.right;
        }
    }
}
