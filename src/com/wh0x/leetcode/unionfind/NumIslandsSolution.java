package com.wh0x.leetcode.unionfind;
/*
 * https://leetcode-cn.com/problems/number-of-islands/
 * leetcode 200
 * 思路：并查集
 */
public class NumIslandsSolution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[] fathers = new int[rows*cols];
        //初始化
        for(int i = 0;i < rows * cols;i++){
            fathers[i] = i;
        }
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(grid[i][j] == '0'){
                    continue;
                }else{
                    //union
                    int currPos = i * cols + j;
                    if(i - 1 >= 0 && grid[i-1][j] == '1')
                        union(currPos,currPos - cols,fathers);
                    if(i + 1 < rows && grid[i+1][j] == '1')
                        union(currPos,currPos + cols,fathers);
                    if(j - 1 >= 0 && grid[i][j-1] == '1')
                        union(currPos,currPos - 1,fathers);
                    if(j + 1 < cols && grid[i][j+1] == '1')
                        union(currPos,currPos + 1,fathers);
                }
            }
        }
        int count = 0;
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(grid[i][j] == '1' && fathers[i*cols+j] == i*cols+j)
                    count++;
            }
        }
        return count;
    }
    public void union(int i,int j,int[] fathers){
        //先find
        //ToDo:rank
        i = find(i,fathers);
        j = find(j,fathers);
        fathers[i] = j;
    }
    public int find(int i,int[] fathers){
        //迭代或者递归
        int j = i;
        while(fathers[i] != i){
            i = fathers[i];
        }
        //路径压缩
        while(j != fathers[j]){
            int next = fathers[j];
            fathers[j] = i;
            j = next;
        }
        return i;
    }
}
