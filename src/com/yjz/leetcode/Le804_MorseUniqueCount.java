package com.yjz.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 唯一摩尔斯密码次
 * Author: yjz
 * CreateDate: 2018-12-21 3:53 PM
 **/
public class Le804_MorseUniqueCount {


    /**
     * 思路：借助字母减去"a"为存储密码的下标。
     * 注意：转换大小写
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> uniqueCode = new HashSet<>();

        for(String word : words) {
            char[] wordCharArray = word.toLowerCase().toCharArray();
            StringBuilder morseStr = new StringBuilder();
            for(char wordChar : wordCharArray) {
                morseStr.append(morseCode[wordChar - 'a']);
            }
            if(!morseStr.toString().equals("")) {
                uniqueCode.add(morseStr.toString());
            }
        }
        return uniqueCode.size();
    }

}
