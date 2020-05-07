package com.wh0x.leetcode;
/*
 * https://leetcode-cn.com/problems/sort-list/
 * leetcode 148
 */
public class SortListSolution {
    public ListNode sortList(ListNode head) {
        /*
         * 用归并排序的递归实现
         * 1.快慢指针找到cut点
         * 2.递归排序
         * 3.merge
         * 注意还有非递归写法，自底向上
         */
        //递归终止条件
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;//断开cut
        return merge(sortList(head),sortList(right));
    }
    private ListNode merge(ListNode p1,ListNode p2){
        //合并两个链表
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                prev.next = p1;
                p1 = p1.next;
            }else{
                prev.next = p2;
                p2 = p2.next;
            }
            prev = prev.next;
        }
        prev.next = p1 == null ? p2 : p1;
        return dummyHead.next;
    }
}
