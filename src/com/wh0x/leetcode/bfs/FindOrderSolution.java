package com.wh0x.leetcode.bfs;

import java.util.*;

/*
 * leetcode 210
 * https://leetcode-cn.com/problems/course-schedule-ii/
 * 思路：参考207
 */
public class FindOrderSolution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] degree = new int[numCourses];
        int[] ans = new int[numCourses];
        int index = 0;
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
            ans[index++] = vertex;
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
        return count == numCourses ? ans : new int[]{};
    }
}
