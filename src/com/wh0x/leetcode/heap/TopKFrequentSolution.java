package com.wh0x.leetcode.heap;

import java.util.*;

/*
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * leetcode 347
 * 思路:hashmap + 堆
 * Time:O(nlogk)
 * Space:O(n)
 */
public class TopKFrequentSolution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        HashMap<Integer,Integer> freqs = new HashMap<>();
        for(int num : nums){
            freqs.put(num,freqs.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return freqs.get(o1) - freqs.get(o2);
            }
        });
        for(int num : freqs.keySet()){
            if(heap.size() < k){
                heap.add(num);
            }else{
                if(freqs.get(num) > freqs.get(heap.peek())){
                    heap.remove(num);
                    heap.add(num);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            res.add(heap.remove());
        }
        return res;
    }
}
