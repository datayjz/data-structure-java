package com.yjz.datastructure.search;


/**
 * Description: 二分查找法
 * Author: yjz
 * CreateDate: 2018-12-24 9:55 AM
 **/
public class BinarySearch {

    public static int search(int[] array,int searchNum) {
        int low = 0;
        int upper = array.length - 1;
        while (low <= upper) {
            int mid = (low + upper) / 2;
            if(array[mid] < searchNum) {
                low = mid + 1;
            } else if (array[mid] > searchNum) {
                upper = mid - 1;
            } else {
                return mid;
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
