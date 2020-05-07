package com.wh0x.leetcode.heap;

import com.wh0x.leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * leetcode 23
 * 思路:构建一个大小为k的最小堆
 * Time:O(nlog(k)) n为所有节点个数
 * Space:O(k)
 */
public class MergeKListsSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        ListNode dummy = new ListNode(-1);
        ListNode preNode = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode node : lists){
            if(node != null)
                pq.add(node);
        }
        while(!pq.isEmpty()){
            ListNode currMin = pq.poll();
            preNode.next = currMin;
            preNode = preNode.next;
            if(currMin.next != null)
                pq.add(currMin.next);
        }
        return dummy.next;
    }
}
