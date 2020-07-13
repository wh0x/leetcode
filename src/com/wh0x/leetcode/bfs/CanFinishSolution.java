package com.wh0x.leetcode.bfs;

import java.util.*;

/*
 * https://leetcode-cn.com/problems/course-schedule/
 * leetcode 207
 * 思路：
 * 利用hashmap存放图，key为起始节点，value为list代表从起始节点出发的所有终点
 * 用一个数组记录所有顶点的入度，入度为0则表示所有依赖都已经具备了，可以入队
 * 然后采取BFS，将入度为0的顶点放入队列中，然后不断出队代表该任务已经完成
 * 判断出队顶点与总课程数是否一致
 */
public class CanFinishSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] degree = new int[numCourses];
        for(int[] prerequisite : prerequisites) {
            //构建图
            if(graph.containsKey(prerequisite[1])) {
                graph.get(prerequisite[1]).add(prerequisite[0]);
            }else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(prerequisite[0]);
                graph.put(prerequisite[1],list);
            }
            //构建入度数组degree   [1,0] ===> 0=>1
            degree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if(degree[i] == 0) {
                queue.add(i);
            }
        }
        //入队出队
        int count = 0;
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            count++;
            List<Integer> tmp = graph.getOrDefault(vertex,null);
            //要进行判断
            if(tmp == null)
                continue;
            for(int courseIndex : tmp) {
                degree[courseIndex]--;
                if(degree[courseIndex] == 0) {
                    queue.add(courseIndex);
                }
            }
        }
        return count == numCourses ? true : false;
    }
}

