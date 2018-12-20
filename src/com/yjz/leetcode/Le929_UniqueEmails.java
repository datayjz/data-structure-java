package com.yjz.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * Author: yjz
 * CreateDate: 2018-12-19 4:42 PM
 **/
public class Le929_UniqueEmails {

    /**
     * 需要注意+和.同时存在需要先把第一个加号后面内容去掉
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmailSet = new HashSet<>();
        for(String email : emails) {
            String[] emailSplit = email.split("@");
            //先判断+规则，将这部分去掉
            int firstAddIndex = emailSplit[0].indexOf("+");
            if(firstAddIndex != -1) {
                emailSplit[0] = emailSplit[0].substring(0,firstAddIndex);
            }
            //判断规则. ，直接使用replace()方法去掉.即可
            emailSplit[0] = emailSplit[0].replace(".","");
            uniqueEmailSet.add(emailSplit[0] + emailSplit[1]);
        }
        return uniqueEmailSet.size();
    }
    //TODO 如何通过正则和流处理

    public static void main(String[] args) {
        Le929_UniqueEmails uniqueEmails = new Le929_UniqueEmails();
        String[] strArray = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int result = uniqueEmails.numUniqueEmails(strArray);
        System.out.println(result);
    }
}
