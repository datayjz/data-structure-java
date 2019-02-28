package com.yjz.datastructure.linearlist;

/**
 * Description:
 * Author: yjz
 * CreateDate: 2019-02-28 11:49 AM
 **/
public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> last;
    private int size;

    public DoubleLinkedList(){
        head = null;
        last = null;
        size = 0;
    }

    public void add(int index,T item) {
        checkIndex(index);
        Node<T> node = new Node<>(null,item,null);
        if(head == last){
            head = node;
            last = node;
        } else {
            if(index == 0) {
                node.next = head;
                head.prev = node;
                head = node;
            } else if(index == size) {
                last.next = node;
                node.prev = last;
                last = node;
            } else {
                Node<T> preNode = getCurNode(index - 1);
                node.next = preNode.next;
                node.prev = preNode;
                preNode.next.prev = node;
                preNode.next = node;
            }
        }
        size++;
    }

    public T remove(int index) {
        checkIndex(index);
        T oldValue;

        if(head == last) {
            oldValue = head.data;
            head = null;
            last = null;
        } else {
            if(index == 0) {
                Node<T> deleteNode = head;
                head = head.next;
                head.prev = null;
                oldValue = deleteNode.data;
                deleteNode.next = null;
                deleteNode.data = null;
            } else if(index == size-1) {
                Node<T> deleteNode = last;
                last = deleteNode.prev;
                last.next = null;
                oldValue = deleteNode.data;
                deleteNode.prev = null;
                deleteNode.data = null;
            } else {
                Node<T> deleteNode = getCurNode(index);
                deleteNode.prev.next = deleteNode.next;
                deleteNode.next.prev = deleteNode.prev;
                oldValue = deleteNode.data;
                deleteNode.prev = null;
                deleteNode.next = null;
                deleteNode.data = null;
            }
        }
        return oldValue;
    }

    public T update(int index,T item) {
        checkIndex(index);
        Node<T> node = getCurNode(index);
        T oldValue = node.data;
        node.data = item;
        return oldValue;
    }

    public T get(int index) {
        checkIndex(index);
        return getCurNode(index).data;
    }
    /**
     * 获取当前节点
     */
    public Node<T> getCurNode(int index) {
        Node<T> node;
        if(index < (size >> 2)) {
            node = head;
            for(int i = 0; i< index; i++) {
                node = node.next;
            }
            return node;
        } else {
            node = last;
            for(int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    private void checkIndex(int index) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
    }

    private class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(Node<T> prev,T data,Node<T> next){
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
}
