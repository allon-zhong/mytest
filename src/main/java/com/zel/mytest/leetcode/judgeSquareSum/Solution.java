package com.zel.mytest.leetcode.judgeSquareSum;

import sun.net.www.protocol.http.HttpURLConnection;

/**
 * ClassName:com.zel.mytest.leetcode.judgeSquareSum.Solution
 * Function:633.判断一个非负整数是否为两个整数的平方和。
 * Reason:
 * date:  2020-01-29 21:14
 *
 * @author zhongel
 */

public class Solution {
    public static void main(String[] args) {
        int c=1000000000;
        boolean b = judgeSquareSum(c);
        System.out.println(b);
    }
    public static boolean judgeSquareSum(int c) {
        for(long a=0;a*a<=c;a++){
            System.out.println(a);
            boolean flag = binary_search(0, c - a * a, c - a * a);
            if(flag){
                return flag;
            }
        }
        return false;
    }

    public static boolean binary_search(long s,long e,long t){
        if(s>e){
            return  false;
        }
        long mid = s+(e-s)/2;
        long temp = mid * mid;
        if(temp==t){
            return true;
        }else if(temp>t){
             return  binary_search(s,mid-1,t);
        }else if(temp<t){
            return  binary_search(mid+1,e,t);
        }
        return false;
    }
}
