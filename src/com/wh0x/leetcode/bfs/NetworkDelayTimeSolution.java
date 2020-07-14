package com.wh0x.leetcode.bfs;

import java.util.Arrays;

/*
 * leetcode 743
 * https://leetcode-cn.com/problems/network-delay-time/
 * 思路：单源最短路径（Dijkstra），求出起始点到其他节点的最短路径，取最大
 * 常规写法以及堆优化
 * ToDo:堆优化写法
 */
public class NetworkDelayTimeSolution {
    //N个节点标记为1 到 N
    public int networkDelayTime(int[][] times, int N, int K) {
        //这里用邻接矩阵构建图
        int[][] graph = new int[N+1][N+1];
        //记录是否访问过，如果图有环则可避免重复访问
        boolean[] visited = new boolean[N+1];
        //记录距离，需要不断更新
        int[] dist = new int[N+1];
        int ans = Integer.MIN_VALUE;
        int cnt = 0;
        //初始化
        for(int i = 1;i <= N;i++) {
            for(int j = 1;j <= N;j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        Arrays.fill(visited,false);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        for(int[] edge : times) {
            graph[edge[0]][edge[1]] = edge[2];
        }
        for (int i = 1; i <= N; i++) {
            //找到最短距离节点
            int index = -1;
            int min = Integer.MAX_VALUE;
            for(int j = 1;j <= N;j++) {
                if(!visited[j]) {
                    if(dist[j] < min){
                        min = dist[j];
                        index = j;
                    }
                }
            }
            if(index == -1)
                continue;
            visited[index] = true;
            cnt++;
            //System.out.println("visited: "+index);
            //更新距离
            for(int j = 1;j <= N;j++) {
                if(graph[index][j] != Integer.MAX_VALUE) {
                    dist[j] = Math.min(dist[j],dist[index] + graph[index][j]);
                }

            }
        }
        //System.out.println(cnt);
        for(int j = 1;j <= N;j++) {
            ans = Math.max(dist[j],ans);
        }
        return cnt == N ? ans : -1;
    }
}

