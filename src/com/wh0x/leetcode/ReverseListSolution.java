package com.wh0x.leetcode;

public class ReverseListSolution {
    public ListNode reverseList(ListNode head) {
        /*
         * 递归

        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
        */
        /*
         * 迭代
         */
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }


}
