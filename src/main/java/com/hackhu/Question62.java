package com.hackhu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Question62 {
    /**
     * 题：序列化二叉树
     * 思路分析：按照前序遍历的思路，从根结点开始构造二叉树.(-1 标志当前结点为空结点)
     * @param stream
     * @return
     */
    public BinaryTree serialize(LinkedList<Integer> stream){
        if (stream == null||stream.size()<1||stream.peek()==-1) {
            stream.pop();
            return null;
        }
        BinaryTree root = new BinaryTree(stream.pop(), null, null);
        if (stream.size() > 0) {
            root.left = serialize(stream);
        }
        if (stream.size() > 0) {
            root.right = serialize(stream);
        }
        return root;
    }

    /**
     * 反序列化二叉树
     * 按照前序遍历思路，依次添加根节点、左子结点、右子结点
     * @param root
     * @return
     */
    public LinkedList<Integer> deserialize(BinaryTree root){
        if (root == null) {
            return null;
        }
        LinkedList<Integer> list = new LinkedList<>();
        deserialize(root, list);
        return list;
    }
    private void deserialize(BinaryTree root,LinkedList<Integer> list){
        if (root == null) {
            list.add(-1);
            return;
        }
        list.add(root.val);
        deserialize(root.left, list);
        deserialize(root.right, list);
    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(-1);
        list.add(-1);
        list.add(-1);
        list.add(3);
        list.add(5);
        list.add(-1);
        list.add(-1);
        list.add(6);
        list.add(-1);
        list.add(-1);
        Question62 q = new Question62();
        BinaryTree tree = q.serialize(list);
        tree.prePrint(tree);
        System.out.println("\n"+q.deserialize(tree));

    }
}
