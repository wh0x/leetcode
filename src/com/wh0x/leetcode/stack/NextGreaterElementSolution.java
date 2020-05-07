package com.wh0x.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * leetcode 496
 * 思路1：暴力法，对于nums1中的每个元素，找到在nums1中的位置然后往后遍历
 * 思路2：用单调栈，对于nums1中的每个元素都找到下一个最大
 * Time:O(n+m)
 * Space:O(n)
 */
public class NextGreaterElementSolution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = nextGreaterElement(nums2);
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
    public Map<Integer,Integer> nextGreaterElement(int[] nums){
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0 ; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            map.put(nums[i],stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums[i]);
        }
        return map;
    }
}
