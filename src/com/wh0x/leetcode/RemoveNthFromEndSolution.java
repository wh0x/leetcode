package com.wh0x.leetcode;

/*
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * leetcode 19
 */
public class RemoveNthFromEndSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n ; i++) {
            fast = fast.next;

        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
