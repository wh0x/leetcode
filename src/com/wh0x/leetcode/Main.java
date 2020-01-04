package com.wh0x.leetcode;

public class Main {
    public static void main(String[] args){
        RemoveDuplicatesSolution solution = new RemoveDuplicatesSolution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int remainLength = solution.removeDuplicates((nums));
        for(int i = 0;i< remainLength;i++){
            System.out.println(nums[i]);
        }
    }
}
