package com.yjz.datastructure.sort;

/**
 * Description: 简单选择排序
 * Author: yjz
 * CreateDate: 2018-12-19 9:40 AM
 **/
public class SelectSort {

    /**
     * 实现原理
     * 1. 使用一层循环来保证每个元素都进行选择排序。
     * 2. 内层循环进行记录比较，选择出最小值或最大值。
     * 3. 将正在进行选择排序的记录与最小值或最大值进行位置交换。
     * 4. 循环上面三个步骤，直到外层循环遍历完。
     */
    public static void selectSort(int[] array){
        int length = array.length;
        for(int i = 0; i < length; i++) {
            int value = array[i];
            int position = i;
            for(int j = i+1; j< length; j++) {
                if(array[j] < value) {
                    value = array[j];
                    position = j;
                }
            }
            array[position] = array[i];
            array[i] = value;
        }
    }

    public static void main(String[] args) {
        int[] array = {8, 1, 3, 5, 7, 11, 4, 6, 10};

        SelectSort.selectSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
