package com.yjz.datastructure.stack;

/**
 * Description:
 * Author: yjz
 * CreateDate: 2019-02-28 2:32 PM
 **/
public class SequenceStack<T> {

    private Object[] stack;
    private int maxSize;
    private int top;

    public SequenceStack(int size) {
        if(size < 0)
            throw new IllegalArgumentException();
        stack = new Object[size];
        maxSize = size;
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(T data) {
        if(!isFull()) {
            stack[++top] = data;
        } else {
            throw new StackOverflowError();
        }
    }

    public T pop() {
        if(!isEmpty()) {
            return (T)stack[top--];
        } else {
            throw new RuntimeException();
        }
    }

    public T peek() {
        if(!isEmpty()) {
            return (T) stack[top];
        } else {
            throw new RuntimeException();
        }
    }
}
