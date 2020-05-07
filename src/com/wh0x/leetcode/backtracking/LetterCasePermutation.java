package com.wh0x.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode-cn.com/problems/letter-case-permutation/submissions/
 * leetcode 784
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if(S == null || S.length() == 0)
            return result;
        backtrack(S.toCharArray(),0,result);
        return result;
    }
    public void backtrack(char[] str,int index,List<String> result){
        if(index == str.length) {
            result.add(String.valueOf(str));
            return;
        }
        backtrack(str,index+1,result);
        if(str[index] < '0' || str[index] > '9'){
            str[index] ^= (1<<5);
            backtrack(str,index+1,result);
        }
    }
}
