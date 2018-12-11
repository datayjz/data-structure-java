package com.yjz.datastructure.tree;

/**
 * Description: 二叉查找树的增删改查
 * Author: yjz
 * CreateDate: 2018-12-11 8:38 AM
 **/
public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    /**
     * 构造二叉树
     */
    public BinarySearchTree(T data) {
        root = new Node<>(null,data,null);
    }


    /**
     * 节点查找
     */
    public boolean searchNode(T data) {
        Node<T> currentNode = root;
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
        Node<T> currentNode = root;
        Node<T> parentNode = root;

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

        Node<T> newNode = new Node<>(null,data,null);

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
     * 获取节点个数
     */
    public int getSize() {
        return getNum(root);
    }

    /**
     * 递归遍历子树个数
     */
    private int getNum(Node<T> node) {
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
    private int getHeigth(Node<T> node) {
        if(node == null) {
            return 0;
        } else {
            int leftHeight = getHeigth(node.left);
            int rightHeight = getHeigth(node.right);
            return (leftHeight < rightHeight) ? rightHeight + 1 : leftHeight + 1;
        }
    }

    private class Node<T extends Comparable<T>>{
        Node<T> left;
        T data;
        Node <T> right;

        public Node(Node<T> left,T data,Node<T> right) {
            this.left = left;
            this.data = data;
            this.right = right;
        }
    }
}
