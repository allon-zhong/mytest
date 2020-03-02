package com.zel.mytest.leetcode.twoSum;

/**
 * ClassName:com.zel.mytest.leetcode.twoSum.Solution
 * Function:167.在有序数组中找出两个数，使它们的和为 target。
 * Reason:
 * date:  2020-01-29 20:17
 *
 * @author zhongel
 */

class Solution {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        int[] ints = twoSum(numbers, 10);
        for(int i=0;i<ints.length;i++){
            System.out.println(ints[i]);
        }
    }
    public static   int[] twoSum(int[] numbers, int target) {
        int[] result = {0,0};
        int start = 1;
        int end = numbers.length-2;
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j]==target){
                    result[0]=i+1;
                    result[1]=j+1;
                    return result;
                }
                if(numbers[i]+numbers[j]>target){
                    break;
                }
            }
        }
        return result;
    }
}
