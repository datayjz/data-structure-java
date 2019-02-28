package com.yjz.datastructure.stack;

/**
 * Description:
 * Author: yjz
 * CreateDate: 2019-02-28 2:54 PM
 **/
public class LinkedStack<T> {

    private Node<T> top;
    private int size;

    public LinkedStack() {
        size = 0;
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        Node<T> node = new Node<>(data,null);
        if(top == null) {
            top = node;
        }
        else {
            node.next = top;
            top = node;
        }
        size++;
    }

    public T pop() {
        if(!isEmpty()) {
            Node<T> node = top;
            top = top.next;
            T value = node.data;
            node.data = null;
            node.next = null;
            size--;
            return value;
        } else {
            throw new RuntimeException();
        }
    }

    public int size() {
        return size;
    }

    public T peek() {
        if(!isEmpty()) {
            return top.data;
        } else {
            throw new RuntimeException();
        }
    }

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data,Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
