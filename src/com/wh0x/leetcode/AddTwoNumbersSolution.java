package com.wh0x.leetcode;

/*
 * https://leetcode-cn.com/problems/add-two-numbers/
 * leetcode 2
 */
public class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        int carry = 0;
        while(l1 != null || l2 != null){
            int value1 = l1 != null? l1.val:0;
            int value2 = l2 != null? l2.val:0;
            int sum = value1 + value2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummyNode.next;


    }
}
