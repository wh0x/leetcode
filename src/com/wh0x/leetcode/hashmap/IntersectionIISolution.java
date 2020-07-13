package com.wh0x.leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
/*
 * leetcode 350
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * 思路：哈希表
 */
public class IntersectionIISolution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) {
            return new int[]{};
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int num : nums2) {
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else{
                map.put(num,1);
            }
        }
        for(int num : nums1){
            int count = map.getOrDefault(num,0);
            if(count > 0){
                ans.add(num);
                map.put(num,count-1);
            }
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();

    }
}
