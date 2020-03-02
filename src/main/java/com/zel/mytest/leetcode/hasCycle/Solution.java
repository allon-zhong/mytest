package com.zel.mytest.leetcode.hasCycle;

import java.util.HashSet;

/**
 * ClassName:com.zel.mytest.leetcode.hasCycle.Solution
 * Function:141.给定一个链表，判断链表中是否有环。
 * Reason:解法一.hash表判断是否已经遍历过
 * date:  2020-01-30 21:35
 *
 * @author zhongel
 */

public class Solution {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        boolean b = hasCycle(listNode1);
        System.out.println(b);

    }

    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        if(head==null){
            return false;
        }
        listNodes.add(head);
        ListNode next = head.next;
        while (next != null) {
            if (listNodes.contains(next)) {
                return true;
            }
            listNodes.add(next);
            next = next.next;
        }
        return false;
    }
}
