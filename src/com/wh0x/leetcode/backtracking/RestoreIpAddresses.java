package com.wh0x.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * 93
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int[] tmp = new int[4];
        if(s == null || s.length() <4)
            return ans;
        backtrack(0,0,s,ans,tmp);
        return  ans;
    }
    public void backtrack(int start,int count,String s,List<String> ans,int[] tmp){
        //递归结束:
        // 1.已经分割了四部分,判断是否到达尾部
        //2.还没分割成四部分就已经到达了尾部
        //System.out.println(start + " " + count);
        if(count == 4) {
            if(start >= s.length()) {
                StringBuffer buf = new StringBuffer();
                for (int i = 0; i < 4; i++) {
                    buf.append(tmp[i]);
                    if (i != 3) {
                        buf.append('.');
                    }
                }
                ans.add(buf.toString());
            }
            return;
        }
        if(start >= s.length())
            return;
        //当前字符为0
        if(s.charAt(start) == '0'){
            tmp[count] = 0;
            backtrack(start+1,count+1,s,ans,tmp);
        }
        //一般情况，往后找，每一个符合条件的addr都能继续dfs下去
        int addr = 0;
        for(int i = start;i < s.length();i++){
            //System.out.println(addr);
            addr = addr * 10 + s.charAt(i) - '0';
            if(addr >0 && addr <= 255){
                tmp[count] = addr;
                backtrack(i+1,count+1,s,ans,tmp);
            }else{
                break;
            }
        }
    }
}
