package com.yjz.datastructure.sort;

/**
 * Description:
 * Author: yjz
 * CreateDate: 2018-12-18 10:27 PM
 **/
public class SheelSort {

    /**
     * 实现原理：
     * 1. 以序列长度的一半作为起始步长，然后对逐一对元素使用该步长进行排序。
     * 2. 以步长分隔的元素作为一个分区序列，然后使用插入排序对该序列进行排序。
     * 3. 将该步长减少一半
     * 4. 循环上面过程，直到步长为1，也就是直接插入排序的过程。
     */
    public static void sheelSort(int[] array) {
        int stepSize = array.length;
        int length = array.length;
        while (stepSize != 0) {
            //每次增量缩减为之前的一般
            stepSize = stepSize / 2;
            //确定分组
            for(int i = 0; i < stepSize; i++) {
                //将指定步长元素进行插入排序
                // 注意这里比较的长度是length，也就是要比较整个序列
                for(int j = i + stepSize; j < length; j+=stepSize) {
                    //已有序的序列中最后一个元素
                    int k = j - stepSize;
                    //要插入的元素
                    int insertNum = array[j];
                    //插入比较
                    while (k >=0 && array[k] > insertNum) {
                        array[k + stepSize] = array[k];
                        k -= stepSize;
                    }
                    array[k+stepSize] = insertNum;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[] array = {8, 1, 3, 5, 7, 11, 4, 6, 10};

        SheelSort.sheelSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
