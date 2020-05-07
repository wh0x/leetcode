package com.wh0x.leetcode;

public class SwapPairsSolution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prevNode = dummyHead;
        while(head != null && head.next != null){
            ListNode temp = head.next.next;
            head.next.next = head;
            prevNode.next = head.next;
            head.next = temp;
            prevNode = head;
            head = head.next;
        }
        return dummyHead.next;
    }
}
