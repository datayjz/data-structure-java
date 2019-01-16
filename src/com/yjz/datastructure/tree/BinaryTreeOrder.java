package com.yjz.datastructure.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
     * 时间复杂度为:O(n)
     * 空间复杂度为:O(n)
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
     * 思路：使用栈作为节点临时存储。在处理完节点后将其入栈，然后处理左子
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public void preOrderNonRecursive(Node<T> currentNode,List<T> result) {
        Stack<Node<T>> stack = new Stack<>();
        while (currentNode != null || !stack.empty()) {

            //如果左子树不为空，则一直向左子树遍历
            if(currentNode != null) {
                //先处理根节点
                result.add(currentNode.data);
                //将当前节点入栈
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                //当左子树为空，开始处理右子树
                //根节点出栈
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
    //后续非递归遍历
    public void postOrderNonRecursive(Node<T> currentNode,List<T> result) {
        Stack<Node<T>> stack = new Stack<>();
        while (true) {
            if(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if(stack.isEmpty()) {
                    return;
                } else {
                    //当没有右子树时才可以访问该节点
                    if(stack.peek().right == null) {
                        currentNode = stack.pop();
                        result.add(currentNode.data);
                        //判断下一个栈顶元素是访问完左子树，还是访问完右子树
                        //如果为右子树访问，则该元素直接取出
                        if(currentNode == stack.peek().right) {
                            result.add(stack.pop().data);
                        }
                    }
                }
                if(!stack.isEmpty()) {
                    //不出栈来获取右子树
                    currentNode = stack.peek().right;
                } else {
                    currentNode = null;
                }
            }
        }
    }

    //层序遍历
    public void levelOrder(Node<T> current,List<T> result) {
        Queue<Node<T>> queue = new LinkedList<>();
        Node<T> tmpNode;
        if(current == null) {
            return;
        }
        queue.offer(current);
        while (!queue.isEmpty()) {
            tmpNode = queue.poll();
            if(tmpNode.left != null) {
                queue.offer(tmpNode.left);
            }
            if(tmpNode.right != null) {
                queue.offer(tmpNode.right);
            }
        }
        queue.clear();
    }

    //递归查找元素最大值
    public int findMax(Node<Integer> current) {
        int rootVal;
        int leftVal;
        int rightVal;
        int max = Integer.MIN_VALUE;
        while (current != null) {
            rootVal = current.data;
            leftVal = findMax(current.left);
            rightVal = findMax(current.right);

            if(leftVal > rightVal) {
                max = leftVal;
            } else {
                max = rightVal;
            }
            if(max < rootVal) {
                max = rootVal;
            }
        }
        return max;
    }

    public int userLevelOrderFindMax(Node<Integer> current) {
        Queue<Node<Integer>> queue = new LinkedList<>();
        Node<Integer> tmpNode;
        int max = Integer.MIN_VALUE;
        if(current == null) {
            return -1;
        }
        queue.offer(current);
        while (!queue.isEmpty()) {
            tmpNode = queue.poll();
            if(tmpNode.data > max) {
                max = tmpNode.data;
            }
            if(tmpNode.left != null) {
                queue.offer(tmpNode.left);
            }
            if(tmpNode.right != null) {
                queue.offer(tmpNode.right);
            }
        }
        return max;
    }



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
