package com.yjz.datastructure.tree;

import java.util.List;
import java.util.Stack;

/**
 * Description: 二叉树排序：前序、中序、后序
 * Author: yjz
 * CreateDate: 2018-12-11 9:25 AM
 **/
public class BinaryTreeOrder<T> {

    private Node<T> root;

    public BinaryTreeOrder(Node<T> root) {
        this.root = root;
    }

    /**
     * 前序递归遍历
     */
    public void preOrderRecursive(Node<T> currentNode,List<T> result) {
        if(currentNode != null) {
            result.add(currentNode.data);
            preOrderRecursive(currentNode.left,result);
            preOrderRecursive(currentNode.right,result);
        }
    }


    /**
     * 前序非递归遍历
     * 思路：使用栈作为节点临时存储(后进先出)
     */
    public void preOrderNonRecursive(Node<T> currentNode,List<T> result) {
        Stack<Node<T>> stack = new Stack<>();
        while (currentNode != null || !stack.empty()) {

            if(currentNode != null) {
                //如果左子树不为空，则一直向左子树遍历
                stack.push(currentNode);
                //先把根节点输出
                result.add(currentNode.data);
                currentNode = currentNode.left;
            } else {
                //当左子树为空
                currentNode = stack.pop();
                currentNode = currentNode.right;
            }
        }
    }

    /**
     * 中序递归遍历
     */
    public void inOrderRecursive(Node<T> currentNode,List<T> result) {
        if(currentNode != null) {
            inOrderRecursive(currentNode.left,result);
            result.add(currentNode.data);
            inOrderRecursive(currentNode.right,result);
        }

    }

    /**
     * 中序遍历非递归
     * 思路：同样用栈先把根节点入栈，当访问完左子树时，在输出结果
     */
    public void inOrderNonRecursive(Node<T> currentNode,List<T> result) {
        Stack<Node<T>> stack = new Stack<>();
        while (currentNode != null || !stack.empty()) {
            //节点不为空，将根节点入栈，继续向左子树遍历
            if(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                //左子树为空，取出根节点，返回结果，然后访问右子树
                currentNode = stack.pop();
                result.add(currentNode.data);
                currentNode = currentNode.right;
            }
        }
    }

    /**
     * 后序递归遍历
     */
    public void postOrderRecursive(Node<T> currentNode,List<T> result) {
        if(currentNode != null) {
            postOrderRecursive(currentNode.left,result);
            postOrderRecursive(currentNode.right,result);
            result.add(currentNode.data);
        }
    }

    //TODO 后序遍历非递归

    private class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(Node<T> left,T data,Node<T> right) {
            this.left = left;
            this.data = data;
            this.right = right;
        }
    }
}
