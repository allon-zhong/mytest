package com.zel.mytest.leetcode.eraseOverlapIntervals;

import javax.swing.event.InternalFrameEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName:com.zel.mytest.leetcode.eraseOverlapIntervals.Solution
 * Function:435.给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * Reason: 用贪心法, 先按照区间结尾排序, 然后选择不重叠区间中结尾最小的区间组成最优解, 多余的数量就是需要移除的重叠区间的个数
 * date:  2020-02-08 22:27
 *
 * @author zhongel
 */

public class Solution {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{1,2},{1,2}};
        int i = eraseOverlapIntervals(intervals);
        System.out.println(i);
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==1){
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(r->r[1]));
        int end=Integer.MIN_VALUE;
        int count = 0;
        for(int[] temp:intervals){
            if(temp[0]>=end){
                end=temp[1];
                count++;
            }
        }
        return intervals.length-count;
    }
}
