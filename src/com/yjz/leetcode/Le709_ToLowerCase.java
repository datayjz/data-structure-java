package com.yjz.leetcode;

/**
 * Description: 手动实现
 * Author: yjz
 * CreateDate: 2018-12-19 5:10 PM
 **/
public class Le709_ToLowerCase {

    /**
     * 需要注意大写字母到消息字母的间隔是32
     */
    public String toLowerCase(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < length;i++) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sb.append((char) (str.charAt(i) + 32));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Le709_ToLowerCase toLowerCase = new Le709_ToLowerCase();
        String result = toLowerCase.toLowerCase("hEllo");
        System.out.println(result);
    }
}
