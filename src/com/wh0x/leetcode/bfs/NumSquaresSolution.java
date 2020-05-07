package com.wh0x.leetcode.bfs;

import java.util.LinkedList;

/*
 * https://leetcode-cn.com/problems/perfect-squares/
 * leetcode 279
 * 思路1:dp dp[i] = min(dp[i],dp[i - j*j]) + 1
 * 思路2：bfs,从根节点出发，下一层的子节点为减去平方数后的数值，若该数值是平方数结束，每一层加1
 */
public class NumSquaresSolution {
    public int numSquares(int n) {
        int result = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(n);
        while(!queue.isEmpty()){
            result++;
            int size = queue.size();
            int tmp = queue.removeFirst();
            for (int i = 0; i < size; i++) {
                //入dui
                for(int j = 1;j * j <= tmp;j++){
                    int nextVal = tmp - j*j;
                    if(nextVal == 0)
                        return result;
                    queue.add(nextVal);
                }
            }
        }
        return -1;
    }
}
