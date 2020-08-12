package com.wh0x.leetcode.bfs;

/**
 * @Author Wang Hao
 * @Date 2020/8/11 22:58
 * @Version 1.0
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 130
 * https://leetcode-cn.com/problems/surrounded-regions/
 * 思路：bfs TODO:dfs
 */
public class Solve {
    public void solve(char[][] board) {
        if(board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        //找到边界上的O并加入队列中
        Queue<Point> q = new LinkedList<>();
        List<Point> preserve = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            if(board[0][j] == 'O') {
                Point p = new Point(0, j);
                q.add(p);
                preserve.add(p);
            }
            if(board[m-1][j] == 'O') {
                Point p = new Point(m-1, j);
                q.add(p);
                preserve.add(p);
            }
        }
        for (int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                Point p = new Point(i, 0);
                q.add(p);
                preserve.add(p);
            }
            if(board[i][n-1] == 'O') {
                Point p = new Point(i, n-1);
                q.add(p);
                preserve.add(p);
            }
        }
        //出队
        while(!q.isEmpty()){
            Point curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            if(visited[x][y])
                continue;
            visited[x][y] = true;
            //遍历四个方向
            if(x - 1 >= 0 && board[x-1][y] == 'O') {
                Point next = new Point(x-1,y);
                q.add(next);
                preserve.add(next);
            }
            if(x + 1 < m && board[x+1][y] == 'O') {
                Point next = new Point(x+1,y);
                q.add(next);
                preserve.add(next);
            }
            if(y - 1 >= 0 && board[x][y-1] == 'O') {
                Point next = new Point(x,y-1);
                q.add(next);
                preserve.add(next);
            }
            if(y + 1 < n && board[x][y+1] == 'O') {
                Point next = new Point(x,y+1);
                q.add(next);
                preserve.add(next);
            }
        }
        //打tag
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        for (int i = 0; i < preserve.size(); i++) {
            Point p = preserve.get(i);
            board[p.x][p.y] = 'O';
        }
    }
}
