package com.wh0x.leetcode;

/*
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * leetcode 25
 */
public class ReverseKGroupSolution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        ListNode prevNode = dummyHead;
        dummyHead.next = head;
        ListNode end = dummyHead;
        while(end.next != null){
            int count = 0;
            while(end != null && count < k){
                end = end.next;
                count++;
            }
            if(end == null)
                break;
            ListNode start = prevNode.next;
            ListNode next = end.next;
            end.next = null;
            prevNode.next = reverse(start);
            start.next = next;
            prevNode = start;
            end = prevNode;
        }
        return dummyHead.next;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
