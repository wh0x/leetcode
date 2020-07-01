package com.wh0x.leetcode.unionfind;
/*
 * https://leetcode-cn.com/problems/friend-circles/
 * leetcode 547
 */
public class FindCircleNumSolution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0)
            return 0;
        int n = M.length;
        int[] fathers = new int[n];
        for (int i = 0; i < n; i++) {
            fathers[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(M[i][j] == 1)
                    union(i, j, fathers);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(fathers[i] == i){
                count++;
            }
        }
        return count;
    }

    public void union(int i,int j,int[] fathers){
        int fatheri = find(i,fathers);
        int fatherj = find(j,fathers);
        fathers[fatheri] = fatherj;
    }
    public int find(int i,int[] fathers){
        int j = i;
        while(i != fathers[i]){
            i = fathers[i];
        }
        while(j != fathers[j]){
            int next = fathers[j];
            fathers[j] = i;
            j = next;
        }
        return i;
    }
}

