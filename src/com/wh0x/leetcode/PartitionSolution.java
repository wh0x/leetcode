package com.wh0x.leetcode;


/*
 * https://leetcode-cn.com/problems/partition-list/
 * leetcode 86
 */
public class PartitionSolution {
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode beforeHead = before;
        ListNode afterHead = after;
        while(head != null){
            if(head.val < x){
                before.next = head;
                before = before.next;
                head = head.next;
            }else{
                after.next = head;
                after = after.next;
                head = head.next;
            }
        }
        before.next = afterHead.next;
        after.next = null;
        return beforeHead.next;

    }
}
