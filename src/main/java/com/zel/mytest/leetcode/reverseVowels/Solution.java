package com.zel.mytest.leetcode.reverseVowels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * ClassName:com.zel.mytest.leetcode.reverseVowels.Solution
 * Function:345.反转字符串中的元音字符
 * Reason:
 * date:  2020-01-29 23:15
 *
 * @author zhongel
 */

public class Solution {
    public static void main(String[] args) {
        String hello = reverseVowels("hellollwerugiko");
        System.out.println(hello);
    }
    public static String reverseVowels(String s) {
        List strings = new ArrayList();
        strings.add('a');
        strings.add('e');
        strings.add('i');
        strings.add('o');
        strings.add('u');
        strings.add('A');
        strings.add('E');
        strings.add('I');
        strings.add('O');
        strings.add('U');
        StringBuffer stringBuffer = new StringBuffer(s);
        int start=0;
        int end = s.length()-1;
        char temp;
        while(start<=end){
            if(strings.contains(s.charAt(start))){
                while(start<end){
                    if(strings.contains(s.charAt(end))){
                        stringBuffer.setCharAt(start,s.charAt(end));
                        stringBuffer.setCharAt(end,s.charAt(start));
                        end--;
                        break;
                    }else{
                        end--;
                    }
                }
            }
            start++;
        }
        return stringBuffer.toString();
    }
}
