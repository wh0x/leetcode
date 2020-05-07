package com.wh0x.leetcode;
/*
 * https://leetcode-cn.com/problems/reorder-list/
 * leetcode 143
 */
public class RecordListSolution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode middleNode = findMiddleNode(head);
        ListNode secondHead = middleNode.next;
        middleNode.next = null;
        ListNode first = head;
        ListNode second = reverseList(secondHead);
        ListNode curr = new ListNode(-1);
        while(second != null){
            curr.next = first;
            first = first.next;
            curr.next.next = second;
            second = second.next;
            curr = curr.next.next;
        }
        if(first != null)
            curr.next = first;


    }
    public ListNode findMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        //返回中间节点对（偶数情况）的前一个节点
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}
