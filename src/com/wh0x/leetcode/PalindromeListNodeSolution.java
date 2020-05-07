package com.wh0x.leetcode;
/*
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * leetcode 234
 */
public class PalindromeListNodeSolution {
    /*
     * 找到中间节点，翻转后半部分，判断是否为回文，恢复链表
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode reverseHead = reverseLinkList(secondHalf);
        ListNode firstCurr = head;
        ListNode secondCurr = reverseHead;
        boolean result = true;
        while(firstCurr != null && secondCurr != null){
            if(firstCurr.val != secondCurr.val){
                result = false;
                break;
            }else{
                firstCurr = firstCurr.next;
                secondCurr = secondCurr.next;
            }
        }
        //恢复链表
        slow.next = reverseLinkList(reverseHead);
        return result;

    }
    private ListNode reverseLinkList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
