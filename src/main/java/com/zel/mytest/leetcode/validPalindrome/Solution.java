package com.zel.mytest.leetcode.validPalindrome;

import org.springframework.web.server.session.HeaderWebSessionIdResolver;

/**
 * ClassName:com.zel.mytest.leetcode.validPalindrome.Solution
 * Function:680.给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * Reason:
 * date:  2020-01-30 19:35
 *
 * @author zhongel
 */

public class Solution {

    public static void main(String[] args) {
        String s="deeee";
        boolean b = validPalindrome(s);
        System.out.println(b);

    }

    public static boolean validPalindrome(String s) {

        int head = 0 ;
        int tail = s.length()-1;
        while (head<=tail){
            if(s.charAt(head) == s.charAt(tail)){
                head++;
                tail--;
            }else{
                String headSubstring = s.substring(head, tail);
                String tailSubstring = s.substring(head+1, tail + 1);

                return validSubString(headSubstring)||validSubString(tailSubstring);
            }
        }
        return true;
    }

    public static boolean validSubString(String s){
        int headSub = 0;
        int tailSub = s.length()-1;

        while (headSub<=tailSub){
            if(s.charAt(headSub) != s.charAt(tailSub)){
                return false;
            }
            headSub++;
            tailSub--;
        }
        return true;
    }
}
