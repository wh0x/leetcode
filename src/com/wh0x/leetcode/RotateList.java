package com.wh0x.leetcode;
/*
 * https://leetcode-cn.com/problems/rotate-list/
 * leetcode 61
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int length = 1;
        ListNode tail = head;
        ListNode newTail = head;
        while(tail.next != null){
            length++;
            tail = tail.next;
        }
        k = k % length;
        if(k == 0)
            return head;
        for (int i = 0; i < length - k - 1 ; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        return newHead;

    }
}
