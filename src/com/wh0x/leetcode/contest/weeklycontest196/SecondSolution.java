package com.wh0x.leetcode.contest.weeklycontest196;
/*
 * https://leetcode-cn.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 */
public class SecondSolution {
    public int getLastMoment(int n, int[] left, int[] right) {
        //灵魂互换，继续走下去就行
        int result = 0;
        if(left != null){
            for(int x : left)
                result = Math.max(result,x);
        }
        if(right != null){
            for(int x : right)
                result = Math.max(result,n - x);
        }
        return result;
    }
}
