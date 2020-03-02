package com.zel.mytest.leetcode.hasCycle;

import java.util.HashSet;

/**
 * ClassName:com.zel.mytest.leetcode.hasCycle.Solution1
 * Function:141.给定一个链表，判断链表中是否有环。
 * Reason:解法二.快慢指针法
 * date:  2020-01-30 22:20
 *
 * @author zhongel
 */

public class Solution1 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        listNode4.next = listNode2;
        boolean b = hasCycle(listNode1);
        System.out.println(b);

    }

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head ;
        ListNode slow = head ;
        while (fast !=null && slow != null && fast.next != null && fast.next.next !=null && slow.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
