package com.zel.mytest.leetcode.findKthLargest;

import java.util.Arrays;

/**
 * ClassName:com.zel.mytest.leetcode.findKthLargest.Solution
 * Function:215.找到无序数组中倒数第k大的值
 * Reason:
 * date:  2020-02-08 11:29
 *
 * @author zhongel
 */

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2 ;
        int kthLargest = findKthLargest(nums, k);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
