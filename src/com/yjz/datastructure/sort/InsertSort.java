package com.yjz.datastructure.sort;

/**
 * Description: 插入排序
 * Author: yjz
 * CreateDate: 2018-12-18 9:53 PM
 **/
public class InsertSort {

    /**
     * 实现思路：
     * 使用一层循环来确定插入次数，从第二个元素开始一直到数组结尾。
     * 里层循环将待插入数据与已经排好序的序列进行比较，如果不满足排序要求，将元素向后移动，
     * 一直找到适合该元素的位置(前一个值小于该元素，后一个值大于该元素)
     */
    public static void insertSort(int[] array) {
        int length = array.length;
        for(int i = 1; i < length;i++) {
            int insertNum = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > insertNum){
                array[j+1] = array[j--];
            }
            array[j+1] = insertNum;
        }
    }

    public static void main(String[] args) {
        int[] array = {8, 1, 3, 5, 7, 11, 4, 6, 10};

        InsertSort.insertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

}
