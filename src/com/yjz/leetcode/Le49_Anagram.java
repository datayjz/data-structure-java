package com.yjz.leetcode;

import java.util.*;

/**
 * Description: 字母异位组合
 * Author: yjz
 * CreateDate: 2018-12-19 3:34 PM
 **/
public class Le49_Anagram {

    public List<List<String>> groupAnagrams(String[] strs) {

        //通过映射来存储异位组合，key为排序后的字符串，这样key就能保证唯一性
        Map<String,List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] strArray = str.toCharArray();
            //算法中排序尽量使用Java自带的排序，因为效率是最高的关于数组的排序Arrays.sort();
            Arrays.sort(strArray);
            String sortedStr = String.valueOf(strArray);
            if(!map.containsKey(sortedStr)) {
                map.put(sortedStr,new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Le49_Anagram anagram = new Le49_Anagram();
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] str1 = {"a", "a"};
        List<List<String>> result = anagram.groupAnagrams(str);
        List<List<String>> result1 = anagram.groupAnagrams(str1);
        System.out.println(result);
        System.out.println(result1);
    }
}
