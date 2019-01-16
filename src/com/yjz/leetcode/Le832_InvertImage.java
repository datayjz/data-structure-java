package com.yjz.leetcode;

/**
 * Description: 反转图像
 * Author: yjz
 * CreateDate: 2018-12-21 3:26 PM
 **/
public class Le832_InvertImage {

    /**
     * 思路：遍历里层元素，如果两边元素不相等不用管，因为结果还要取反
     * 注意：当个数为偶数时，中间元素处理
     */
    public int[][] flipAndInvertImage(int[][] array) {
        int length = array.length;
        for(int i = 0;i < length;i++) {
            int[] insideArray = array[i];
            int first = 0;
            int last = insideArray.length-1;
            while (first < last) {
                //当两边元素不等时不用管
                if(insideArray[first] == insideArray[last]) {
                    if(insideArray[first] == 0) {
                        insideArray[first] = insideArray[last] = 1;
                    } else {
                        insideArray[first] = insideArray[last] = 0;
                    }
                }
                first++;
                last--;
            }
            if(first == last) {
                if(insideArray[first] == 0){
                    insideArray[first] = 1;
                } else {
                    insideArray[last] = 0;
                }
            }
        }
        return array;
    }
}
