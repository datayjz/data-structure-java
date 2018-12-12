package com.yjz.datastructure.tree;

/**
 * Description: 二叉树基本操作，获取子树高度、节点数等
 * Author: yjz
 * CreateDate: 2018-12-12 9:59 AM
 **/
public class BinaryTree<T> {


    private TreeNode<T> root;

    public BinaryTree(TreeNode<T> root) {
        this .root = root;
    }


    /**
     * 获取节点个数
     */
    public int getSize() {
        return getNum(root);
    }

    /**
     * 递归遍历子树个数
     */
    private int getNum(TreeNode<T> node) {
        if(node == null) {
            return 0;
        } else {
            int leftNum = getNum(node.left);
            int rightNum = getNum(node.right);
            return leftNum + rightNum + 1;
        }
    }

    /**
     * 获取数的高度
     */
    public int getHeigth(){
        return getHeigth(root);
    }

    /**
     * 递归获取节点高度
     */
    private int getHeigth(TreeNode<T> node) {
        if(node == null) {
            return 0;
        } else {
            int leftHeight = getHeigth(node.left);
            int rightHeight = getHeigth(node.right);
            return (leftHeight < rightHeight) ? rightHeight + 1 : leftHeight + 1;
        }
    }

    private class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(TreeNode<T> left,T data,TreeNode<T> right) {
            this.left = left;
            this.data = data;
            this.right = right;
        }
    }
}
