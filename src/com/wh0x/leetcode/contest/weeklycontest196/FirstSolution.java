package com.wh0x.leetcode.contest.weeklycontest196;

import java.util.Arrays;

public class FirstSolution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr == null || arr.length == 0)
            return false;
        Arrays.sort(arr);
        int temp = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if(arr[i] - arr[i-1] != temp)
                return false;
        }
        return true;
    }
}
