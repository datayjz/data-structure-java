package com.yjz.datastructure.queue;

/**
 * Description:
 * Author: yjz
 * CreateDate: 2019-02-28 3:06 PM
 **/
public class ArrayQueue<T> {

    private Object[] data;
    private int front;
    private int rear;
    private int maxSize;

    public ArrayQueue(int size) {
        if(size < 0)
            throw new IllegalArgumentException();
        data = new Object[size];
        maxSize = size;
        front = rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == (maxSize - 1);
    }

    public void offer(T item) {
        if(!isFull()) {
            data[rear++] = item;
        } else {
            throw new RuntimeException();
        }
    }

    public T pop() {
        if(!isEmpty()) {
            T value = (T) data[front];
            data[front++] = null;
            return value;
        } else {
            throw new RuntimeException();
        }
    }

    public T peek() {
        if(!isEmpty()) {
            return (T) data[front];
        } else {
            throw new RuntimeException();
        }
    }

}
