package com.wh0x.leetcode.contest.weeklycontest198;

public class FirstSolution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        int x = 0;
        while(numBottles > 0 || x > numExchange) {
            ans += numBottles;
            x += numBottles;
            numBottles = x / numExchange;
            x = x % numExchange;
        }
        return ans;
    }
}
