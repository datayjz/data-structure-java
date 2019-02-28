package com.yjz.datastructure.queue;

/**
 * Description:
 * Author: yjz
 * CreateDate: 2019-02-28 3:24 PM
 **/
public class LinkedQueue<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LinkedQueue() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T data) {
        Node<T> node = new Node<>(data,null);
        if(isEmpty()) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public T pop() {
        if(!isEmpty()) {
            Node<T> node = front;
            front = front.next;
            T value = node.data;
            node.data = null;
            node.next = null;
            size--;
            return value;
        } else {
            throw new RuntimeException();
        }
    }

    public T peek() {
        if(!isEmpty()) {
            return (T) front.data;
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
