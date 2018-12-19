package com.yjz.datastructure.sort;

/**
 * Description: 冒泡排序
 * Author: yjz
 * CreateDate: 2018-12-17 9:28 AM
 **/
public class BubbleSort {


    /**
     * 冒泡排序升序
     * 实现思路：
     * 外层循环控制扫描次数。
     * 内层循环控制比较，需要注意的是相邻比较，只需要判断到n-1即可。
     * 借助额外内存空间进行元素对换。
     *
     */
    public static void bubbleSort(int[] array) {
        int len = array.length;
        for(int i = 0; i < len - 1; i ++) {
            for(int j = 0; j < len - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 使用一个岗哨判断是否有交换，如果没有提前退出循环。
     */
    public static void bubbleSort2(int[] array) {
        int len = array.length;
        for(int i = 0;i < len - 1; i++) {
            boolean nonSwap = true;
            for(int j = 0; j < len-i-1; j++){
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    nonSwap = false;
                }
            }
            if(nonSwap) break;
        }
    }

    public static void main(String[] args) {
        int[] array = {8,1,3,5,7,11,4,6,10};

        BubbleSort.bubbleSort(array);
        for(int i=0;i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
