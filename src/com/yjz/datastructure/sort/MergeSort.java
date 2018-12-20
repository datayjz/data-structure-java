package com.yjz.datastructure.sort;

/**
 * Description: 归并排序
 * Author: yjz
 * CreateDate: 2018-12-19 10:15 PM
 **/
public class MergeSort {

    public static void sort(int[] array) {
        mergeSort(array,0,array.length-1);
    }

    public static void mergeSort(int[] array,int left,int right){

        if (left < right) {
            int middle = (left + right) / 2;
            //递归拆分
            mergeSort(array,left,middle);
            mergeSort(array,middle+1,right);
            //合并
            merge(array,left,middle,right);
        }

    }

    private static void merge(int[] array,int left,int middle,int right) {
        int[] tmpArray = new int[array.length];
        int tmpStartIndex = left;
        int tmpLeft = left;
        int tmpMiddle = middle + 1;
        while (tmpLeft <= middle && tmpMiddle <= right) {
            if(array[tmpLeft] <= array[tmpMiddle]) {
                tmpArray[tmpStartIndex++] = array[tmpLeft++];
            } else {
                tmpArray[tmpStartIndex++] = array[tmpMiddle++];
            }
        }
        while (tmpLeft <= middle) {
            tmpArray[tmpStartIndex++] = array[tmpLeft++];
        }
        while (tmpMiddle <= right) {
            tmpArray[tmpStartIndex++] = array[tmpMiddle++];
        }
        while (left <= right) {
            array[left] = tmpArray[left++];
        }
    }

    public static void main(String[] args) {
        int[] array = {8, 1, 3, 5, 7, 11, 4, 6, 10};

        MergeSort.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
