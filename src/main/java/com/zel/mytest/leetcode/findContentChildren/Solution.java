package com.zel.mytest.leetcode.findContentChildren;

import java.util.Arrays;

/**
 * ClassName:com.zel.mytest.leetcode.findContentChildren.Solution
 * Function:455. 分发饼干 贪心策略,每次给当前满足度最小的孩子分派满足其胃口的最小尺寸的饼干, 每次都保证局部最优, 得到全局最优解
 * Reason:
 * date:  2020-02-08 22:06
 *
 * @author zhongel
 */

public class Solution {
    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        int contentChildren = findContentChildren(g, s);
        System.out.println(contentChildren);
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (s[j] >= g[i]) {
                result++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return result;
    }
}
