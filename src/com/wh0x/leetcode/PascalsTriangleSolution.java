package com.wh0x.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode-cn.com/problems/pascals-triangle/
 * leetcode 118
 */
public class PascalsTriangleSolution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        for(int i = 0;i < numRows;i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0;j <= i;j++){
                if(j == 0 || j == i){
                    row.add(1);
                }else{
                    row.add(triangle.get(i-1).get(j) + triangle.get(i-1).get(j-1));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
