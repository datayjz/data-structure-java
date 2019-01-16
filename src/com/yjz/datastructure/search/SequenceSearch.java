package com.yjz.datastructure.search;

/**
 * Description: 顺序查找
 * Author: yjz
 * CreateDate: 2018-12-24 9:42 AM
 **/
public class SequenceSearch {

    public static int search(int[] array,int searchNum) {
        int length = array.length;
        for(int i = 0;i < length; i++) {
            if(array[i] == searchNum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {8, 1, 3, 5, 7, 11, 4, 6, 10};
        int result = search(array,7);
        System.out.println(result);
    }
}
