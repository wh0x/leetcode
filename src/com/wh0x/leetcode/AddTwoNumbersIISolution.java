package com.wh0x.leetcode;

import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * leetcode 445
 */
public class AddTwoNumbersIISolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int carry = 0;
        ListNode node = null;
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        while(!s1.empty() || !s2.empty()){
            int value1 = s1.empty()? 0:s1.pop();
            int value2 = s2.empty()? 0:s2.pop();
            int sum = value1 + value2 + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = node;
            node = newNode;


        }
        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            newNode.next = node;
            node = newNode;
        }
        return node;

    }
}