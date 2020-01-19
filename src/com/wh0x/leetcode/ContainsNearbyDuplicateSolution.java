package com.wh0x.leetcode;

import java.util.HashMap;

public class ContainsNearbyDuplicateSolution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0 || nums == null){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else{
                if(i - map.get(nums[i]) <= k){
                    return true;
                }
                else{
                    map.put(nums[i],i);
                }
            }
        }
        return false;

    }
}
