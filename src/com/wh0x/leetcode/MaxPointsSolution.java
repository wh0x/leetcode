package com.wh0x.leetcode;

import java.util.HashMap;

public class MaxPointsSolution {
    public int maxPoints(int[][] points) {
        if(points == null) {
            return 0;
        }else{
            if(points.length < 3){
                return points.length;
            }
        }
        int result = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0;i < points.length;i++){
            map.clear();
            int duplicates = 0;
            int curr_max = 0;
            for(int j = i + 1;j < points.length;j++){
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                if(dx == 0 && dy == 0){
                    duplicates ++;
                    continue;
                }
                String key = getSlope(dx,dy);
                map.put(key,map.getOrDefault(key,0)+1);
                curr_max = Math.max(curr_max,map.get(key));
            }
            result = Math.max(result,curr_max + duplicates + 1);
        }
        return result;

    }
    private String getSlope(int dx,int dy){
        /*
         * get slope,slope represented by fenzi and fenmu
         */
        int gcd = gcd(dx,dy);
        int x = dx / gcd;
        int y = dy / gcd;
        return x + "/" + y;
    }
    private int gcd(int a,int b){
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
