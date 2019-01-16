package com.yjz.leetcode;

/**
 * Description: 奇偶数排序
 * Author: yjz
 * CreateDate: 2018-12-21 3:11 PM
 **/
public class Le905_SortParity {

    /**
     * 思路：借助一个下游标记位，从头开始记录偶数的位置
     */
    public int[] sortArrayByParity(int[] A) {
        int length = A.length;
        int index =0;
        for(int i = 0;i < length;i++){
            if(A[i] % 2 == 0) {
                int tmp = A[i];
                A[i] = A[index];
                A[index++] = tmp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] array = {3,1,2,4};
        Le905_SortParity sortParity = new Le905_SortParity();
        int[] result = sortParity.sortArrayByParity(array);
        for (int r : result) {
            System.out.println(r);
        }
    }
}
