package com.yjz.datastructure.linearlist;

/**
 * Description:
 * Author: yjz
 * CreateDate: 2019-02-28 11:33 AM
 **/
public class LoopLinkedList<T> {
    private Node<T> head;
    private int size;

    /**
     * 头插法
     */
    public void add(T item) {
        Node<T> node = new Node<>(item,null);
        if(head == null) {
            head = node;
        } else {
            Node<T> tmpNode = head;
            while (tmpNode.next != head)
                tmpNode = tmpNode.next;
            node.next = head;
            tmpNode.next = node;
            head = tmpNode;
        }
    }

    /**
     * 删除头节点
     */
    public T remove() {
        Node<T> node = head;
        while (node.next != head)
            node = node.next;

        Node<T> deleteNode = head;
        head = head.next;
        node.next = head;
        T oldValue = deleteNode.data;
        deleteNode.data = null;
        deleteNode.next = null;
        return oldValue;
    }

    private class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
