package com.yjz.datastructure.queue;

/**
 * Description:
 * Author: yjz
 * CreateDate: 2019-02-28 3:15 PM
 **/
public class LoopArrayQueue<T> {

    private Object[] queue;
    private int size;
    private int maxSize;
    private int front;
    private int rear;

    public LoopArrayQueue(int size) {
        if(size < 0) {
            throw new IllegalArgumentException();
        } else {
            queue = new Object[size];
            maxSize = size;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public void push(T data) {
        if(!isFull()) {
            rear = (rear + 1) % maxSize;
            queue[rear] = data;
            size++;
        } else {
            throw new RuntimeException();
        }
    }

    public T pop() {
        if(!isEmpty()) {
            front = (front + 1) % maxSize;
            T value = (T)queue[front];
            queue[front] = null;
            size--;
            return value;
        } else {
            throw new RuntimeException();
        }
    }

    public T peek() {
        if(!isEmpty()) {
            return (T) queue[(front + 1) % maxSize];
        } else {
            throw new RuntimeException();
        }
    }

    public int size() {
        return size;
    }
}
