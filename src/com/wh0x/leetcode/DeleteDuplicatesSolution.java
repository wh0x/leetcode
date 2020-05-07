package com.wh0x.leetcode;

/*
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * leetcode 82
 */
public class DeleteDuplicatesSolution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.val != curr.next.val){
                pre = curr;
                curr = curr.next;
            }else{
                while(curr != null && curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                if(curr == null){
                    pre.next = null;
                }else{
                    pre.next = curr.next;
                    curr = curr.next;
                }
            }
        }
        return dummyHead.next;

    }
}
