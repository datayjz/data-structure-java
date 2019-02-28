package com.yjz.datastructure.linearlist;

import java.util.Arrays;

/**
 * Description:
 * Author: yjz
 * CreateDate: 2019-02-28 9:58 AM
 **/
public class ArrayList<T> {
    private Object[] data;
    private int size;
    private int DEFAULT_CAPATITY = 10;

    public ArrayList() {
        data = new Object[DEFAULT_CAPATITY];
    }

    public ArrayList(int length) {
        if(length < 0) {
            throw new IllegalArgumentException("length illegal:" + length);
        }
        data = new Object[length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T item) {
        ensureCapacity(size + 1);
        data[size++] = item;
    }

    public T update(int index,T item) {
        checkIndex(index);
        T oldValue = (T)data[index];
        data[index] = item;
        return oldValue;
    }

    public T delete(int index) {
        checkIndex(index);
        T oldValue = (T) data[index];
        System.arraycopy(data,index+1,data,index,size - index - 1);
        //赋null的同时，减少了长度
        data[--size] = null;
        return oldValue;
    }

    private void checkIndex(int index) {
        if(index < 0 || index > data.length)
            throw new IndexOutOfBoundsException();
    }

    private void ensureCapacity(int minCapacity) {
        if(minCapacity > data.length)
            grow(minCapacity);
    }
    private void grow(int minCapacity) {
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 2);
        if(oldCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        if(minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        data = Arrays.copyOf(data,newCapacity);
    }
}
