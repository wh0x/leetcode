package com.wh0x.leetcode;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicateSolution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        /*
        for(int i = 0;i < nums.length; i++){
            for(int j = Math.max(i - k,0);j < i;j++){
                if(Math.abs((long) nums[i] - nums[j]) <= t){
                    System.out.println(""+i+" "+j+" "+Math.abs(nums[i] - nums[j]));
                    return true;
                }
            }
        }
        */
        if(nums == null || nums.length < 2){
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0;i < nums.length; i++){
            Long right = set.ceiling((long)nums[i]);
            if(right != null && right <= (long)(nums[i] + t)){
                return true;
            }
            Long left = set.floor((long)nums[i]);

            if(left != null && (left + t) >= nums[i]){
                return true;
            }
            set.add((long)nums[i]);
            if(set.size() > k){
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
