package com.wh0x.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 1 || k < 1)
            return new int[]{};
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i < k;i++){
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);
        }
        result[0] = nums[deque.peekFirst()];
        int index = 1;
        for(int i = k;i < nums.length;i++){
            if(nums[deque.peekFirst()] == nums[i-k]){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
            result[index++] = nums[deque.peekFirst()];
        }
        return result;
    }
}
