package com.wh0x.leetcode.contest.weeklycontest198;


import java.util.LinkedList;
import java.util.Queue;

public class SecondSolution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] ans = new int[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(visited[curr])
                continue;
            visited[curr] = true;
            ans[curr] = bfs(n,curr,edges,labels);
            for(int[] tmp : edges) {
                if(tmp[0] == curr || tmp[1] == curr)
                    queue.add(tmp[0] == curr ? tmp[1] : tmp[0]);
            }
        }
        return ans;
    }
    public int bfs(int n,int curr,int[][] edges,String labels) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int ans = 0;
        queue.add(curr);
        while(!queue.isEmpty()){
            int x = queue.poll();
            if(visited[curr])
                continue;
            visited[curr] = true;
            if(labels.charAt(x) == labels.charAt(curr))
                ans++;
            for(int[] tmp : edges) {
                if(tmp[0] == x || tmp[1] == x)
                    queue.add(tmp[0] == x ? tmp[1] : tmp[0]);
            }
        }
        return ans;
    }
}
