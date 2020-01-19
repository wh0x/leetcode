package com.wh0x.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateSolution {
    /*
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                return true;
            }else{
                map.put(num,0);
            }
        }
        return false;

    }
    */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }


}
