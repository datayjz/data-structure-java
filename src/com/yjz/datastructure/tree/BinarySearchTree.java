package com.yjz.datastructure.tree;

/**
 * Description: 二叉查找树的增删改查
 * Author: yjz
 * CreateDate: 2018-12-11 8:38 AM
 **/
public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    /**
     * 构造二叉树
     */
    public BinarySearchTree(T data) {
        root = new TreeNode<>(null,data,null);
    }


    /**
     * 节点查找
     */
    public boolean searchNode(T data) {
        TreeNode<T> currentNode = root;
        while(true) {
            //一直搜索到节点为null，都没有找到
            if(currentNode == null) {
                return false;
            }
            int tmp = currentNode.data.compareTo(data);

            if (tmp < 0) {
                currentNode = currentNode.right;
            } else if (tmp > 0){
                currentNode = currentNode.left;
            } else {
                return true;
            }
        }
    }

    /**
     * 节点添加
     */
    public boolean addNode(T data) {
        TreeNode<T> currentNode = root;
        TreeNode<T> parentNode = root;

        //查找要插入节点的父节点
        while (currentNode != null) {
            int tmp = currentNode.data.compareTo(data);
            parentNode = currentNode;
            if(tmp < 0) {
                currentNode = currentNode.right;
            } else if(tmp > 0) {
                currentNode = currentNode.left;
            } else {
                throw new IllegalStateException("insert data exit!");
            }
        }

        TreeNode<T> newNode = new TreeNode<>(null,data,null);

        if(parentNode != null) {
            if(parentNode.data.compareTo(data) < 0) {
                parentNode.right = newNode;
            } else {
                parentNode.left = newNode;
            }
        } else {
            root = newNode;
        }
        return true;
    }

    /**
     * 既然删除分为三种情况，那么我们可以把第三种情况转换成前两种情况
     * @param node
     * @return
     */
    public boolean deleteNode(TreeNode<T> node) {
        //将要删除的节点与其后继节点交换
        if(node.left != null && node.right != null) {
            //查找右子树的最小值
            TreeNode<T> minNode = node.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //将右子树最小值节点与当前要删除节点交换
            node.data = minNode.data;
            //将要删除节点指向最小值节点，这样我们就考虑如何删除最小值节点。
            //最小值节点要么一个节点(这时候一点事右节点)，要么就是一个叶子节点，这样就转化成删除第一种和第二种节点方案了
            node = minNode;
        }

        //找到要删除节点的孩子节点
        TreeNode<T> childNode;
        if(node.left != null) {
            childNode = node.left;
        } else {
            childNode = node.right;
        }

        //找到要删除节点的父节点
        TreeNode<T> parentNode = searchParentNode(node);

        //parentNode为空，说明删除的是根节点
        if(parentNode == null) {
            root = childNode;
        } else if(parentNode.left == node) {
            parentNode.left = childNode;
        } else {
            parentNode.right = childNode;
        }
        return true;
    }


    /**
     * 查找父节点
     */
    private TreeNode<T> searchParentNode(TreeNode<T> node) {
        TreeNode<T> currentNode = root;
        TreeNode<T> parentNode = null;
        while (currentNode != null) {
            parentNode = currentNode;
            int cmp = currentNode.data.compareTo(node.data);
            if(cmp < 0) {
                currentNode = currentNode.right;
            } else if(cmp > 0){
                currentNode = currentNode.left;
            } else {
                //找到该节点
                break;
            }
        }
        return parentNode;
    }




    private class TreeNode<T extends Comparable<T>>{
        TreeNode<T> left;
        T data;
        TreeNode <T> right;

        public TreeNode(TreeNode<T> left,T data,TreeNode<T> right) {
            this.left = left;
            this.data = data;
            this.right = right;
        }
    }
}
