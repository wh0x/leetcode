package com.wh0x.leetcode;

/*
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * leetcode 203
 */
public class RemoveElementsSolution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        while(head != null){
            if(head.val != val){
                node.next = head;
                node = node.next;
            }
            head = head.next;
        }
        node.next = null;
        return dummyHead.next;

    }

}
