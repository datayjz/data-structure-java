package com.yjz.datastructure.linearlist;

/**
 * Description:
 * Author: yjz
 * CreateDate: 2019-02-28 10:28 AM
 **/
public class SingleLinkedList<T> {

    private Node<T> head;
    private Node<T> last;
    private int size;

    public SingleLinkedList() {
    }

    public void add(int index,T item) {
        checkIndex(index);
        Node<T> node = new Node<>(item,null);
        if(head == last) {
            head = node;
            last = node;
        } else {
            if(index == size){
                last.next = node;
                last = node;
            } else if(index == 0) {
                node.next = head;
                head = node;
            } else {
                Node<T> tmpNode = getPrevNode(index);
                node.next = tmpNode.next;
                tmpNode.next = node;
            }
        }
        size++;
    }

    public T update(int index,T item) {
        checkIndex(index);
        Node<T> node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        T oldValue = node.data;
        node.data = item;
        return oldValue;
    }

    public T delete(int index){
        checkIndex(index);
        T oldValue;
        if(head == last) {
            oldValue = head.data;
            head = null;
            last = null;
        } else {
            if(index == 0) {
                Node<T> tmpNode = head;
                head = head.next;
                oldValue = tmpNode.data;
                tmpNode.next = null;
                tmpNode.data = null;
            } else {
                Node<T> tmpNode = getPrevNode(index);
                Node<T> deleteNode = tmpNode.next;
                tmpNode.next = deleteNode.next;
                oldValue = deleteNode.data;
                deleteNode.data = null;
                deleteNode.next = null;
            }
        }
        return oldValue;
    }

    private Node<T> getPrevNode(int index){
        Node<T> node = head;
        for(int i = 0; i < index - 1;i++) {
            node = node.next;
        }
        return node;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    private class Node<T>{
        T data;
        Node<T> next;

        public Node(T data,Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
