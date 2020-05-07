package com.wh0x.leetcode;
/*
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * leetcode 21
 */
public class mergeTwoListsSolution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode node = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;

        }
        node.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }
}
