package com.zel.mytest.leetcode.findKthLargest;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * ClassName:com.zel.mytest.leetcode.findKthLargest.Solution1
 * Function:堆排序 215.找到无序数组中倒数第k大的值
 * Reason:
 * date:  2020-02-08 11:37
 *
 * @author zhongel
 */

public class Solution1 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2 ;
        int kthLargest = findKthLargest(nums, k);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        //优先级队列实现最小堆, 堆顶元素为按自然排序的最小值
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        for(Integer temp:nums){
            integers.add(temp);
            if(integers.size()>k){
                integers.poll(); //弹出堆顶元素
            }
        }
        return integers.peek();//获取堆顶元素, 即为倒数第k大的值
    }
}
