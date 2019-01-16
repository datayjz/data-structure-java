package com.yjz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 奇偶数排序II
 * Author: yjz
 * CreateDate: 2018-12-21 4:21 PM
 **/
public class Le922_ParitySortII {
    /**
     * 思路：这道题第一次我用一个数组先把不符合偶数的下标记录下来的，然后在遍历奇数
     * 看了别人的解题代码，其实当我们判断一个偶数不满足需求时，就可以去找不满足需求的奇数去就可以了。
     * 找奇数有技巧，因为是从头开始找的，只要一直记录它就可以，不需要每次从头开始。
     */
    public int[] sortArrayByParityII(int[] array) {
        int length = array.length;

        int j = 1;
        for(int i = 0;i < length; i += 2) {
            if(array[i] % 2 != 0){
                while (array[j] % 2 == 1) {
                    j += 2;
                }
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Le922_ParitySortII paritySortII = new Le922_ParitySortII();
        int[] array = {4,2,5,7};
        int[] result = paritySortII.sortArrayByParityII(array);
        for(int s : result) {
            System.out.print(s + ",");
        }
    }
}
