package com.yjz.datastructure.sort;

/**
 * Description: 快速排序
 * Author: yjz
 * CreateDate: 2018-12-18 9:03 AM
 **/
public class QuickSort {

    public static void quickSort(int[] array) {
        if (array == null || array.length < 1) {
            throw new IllegalArgumentException("array is null or empty!");
        }
        quickSort(array, 0, array.length - 1);
    }

    /**
     * 快速排序升序
     * 实现思路：
     * 外层循环保证左右游标不等这样能够确保每次排序都将所有元素遍历。
     * 内层两个循环分别将左右子序列值和基准值比较，不满足情况交换位置。
     */
    private static void quickSort(int[] array, int start, int end) {

        if(start >= end)
            return;

        int left = start;
        int right = end;
        //确定基准值，使用基准值进行分区，默认采用最左侧元素
        int baseValue = array[left];
        while (left < right) {
            while (left < right && array[right] >= baseValue) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= baseValue) {
                left++;
            }
            array[right] = array[left];
        }
        //分区元素放到正确位置
        array[left] = baseValue;
        quickSort(array, start, left - 1);
        quickSort(array, left + 1, end);
    }

    public static void main(String[] args) {
        int[] array = {8, 1, 3, 5, 7, 11, 4, 6, 10};

        QuickSort.quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
