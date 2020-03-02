package com.zel.mytest.leetcode.judgeSquareSum;

/**
 * ClassName:com.zel.mytest.leetcode.judgeSquareSum.Solution1
 * Function:633.判断一个非负整数是否为两个整数的平方和。
 * Reason:
 * date:  2020-01-29 22:21
 *
 * @author zhongel
 */

public class Solution1 {
    public static void main(String[] args) {
        int c = 1000000000;
        boolean b = judgeSquareSum(c);
        System.out.println(b);
    }
    public static boolean judgeSquareSum(int c) {
        Double sqrt = Math.sqrt(c);
        int e = sqrt.intValue();
        int s = 0;
        while(e>=s){
            int temp = e * e + s * s;
            if(temp==c){
                return true;
            }else if(temp>c){
                e--;
            }else if(temp<c){
                s++;
            }
        }
        return false;
    }
}
