package com.wh0x.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * leetcode 785
 * https://leetcode-cn.com/problems/is-graph-bipartite/
 * 思路：BFS(图不一定是联通的，从一个节点出发可能无法遍历完，
 * 用一个数组来记录节点的状态，未标记，已标记为A
 * 已标记为B)
 */
public class IsBipartiteSolution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] status = new int[n];
        for (int i = 0; i < n; i++) {
            if(status[i] != 0)
                continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            status[i] = 1;
            while(!queue.isEmpty()) {
                int curr = queue.poll();
                for(int neighbor : graph[curr]) {
                    if(status[neighbor] == 0) {
                        status[neighbor] = status[curr] == 1 ? 2 : 1;
                        queue.add(neighbor);
                    }else {
                        if(status[neighbor] == status[curr]){
                            //System.out.println(neighbor + ":" + status[neighbor] + " " + curr + ":" + status[curr]);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
