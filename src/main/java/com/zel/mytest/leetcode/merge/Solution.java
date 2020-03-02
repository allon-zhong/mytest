package com.zel.mytest.leetcode.merge;

/**
 * ClassName:com.zel.mytest.leetcode.merge.Solution
 * Function:88.给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * Reason:
 * date:  2020-01-30 20:37
 *
 * @author zhongel
 */

public class Solution {

    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge(nums1,3,nums2,3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result=new int[m+n];
        int point1 = 0;
        int point2 = 0;
        while (point1<=m && point2<=n){
            if(point1==m && point2==n){
                break;
            }
            if(point1==m){
                result[point1+point2]=nums2[point2];
                point2++;
                continue;
            }
            if(point2==n){
                result[point1+point2]=nums1[point1];
                point1++;
                continue;
            }
            if(  nums1[point1]<=nums2[point2]){
                result[point1+point2]=nums1[point1];
                point1++;
                continue;
            }else  {
                result[point1+point2]=nums2[point2];
                point2++;
                continue;
            }
        }
        System.arraycopy(result, 0, nums1, 0, result.length);
    }
}
