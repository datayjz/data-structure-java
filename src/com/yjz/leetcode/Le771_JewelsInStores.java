package com.yjz.leetcode;

/**
 * Description:
 * Author: yjz
 * CreateDate: 2018-12-19 4:33 PM
 **/
public class Le771_JewelsInStores {

    public int numJewelsInStones(String J, String S) {
        int result = 0;
        int lengthJ = J.length();
        int lengthS = S.length();
        for(int i = 0; i < lengthS; i++) {
            for(int j = 0; j < lengthJ; j++) {
                if(S.charAt(i) == J.charAt(j)) {
                    result +=1;
                    //宝石类型字符串不重复，碰到即可结束本次循环
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Le771_JewelsInStores jewelsInStores = new Le771_JewelsInStores();
        int result = jewelsInStores.numJewelsInStones("aA","aAAbbbb");
        int result2 = jewelsInStores.numJewelsInStones("z","ZZ");
        System.out.println(result);
        System.out.println(result2);
    }
}
