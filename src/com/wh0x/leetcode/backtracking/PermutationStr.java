package com.wh0x.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode-cn.com/problems/permutation-i-lcci/
 *
 */
public class PermutationStr {
    public String[] permutation(String S) {
        if(S == null || S.length() == 0){
            return new String[0];
        }
        List<String> result = new ArrayList<>();
        char[] array = S.toCharArray();
        boolean[] used = new boolean[array.length];
        helper(array,used,"",result);
        String [] ret=new String[result.size()];
        return result.toArray(ret);
    }
    public void helper(char[] array,boolean[] used,String str,List<String> result){
        if(str.length() == array.length){
            result.add(str);
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if(!used[i]){
                used[i] = true;
                helper(array,used,str+array[i],result);
                used[i] = false;
            }
        }
    }

}
