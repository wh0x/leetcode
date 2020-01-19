package com.wh0x.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagramsSolution{
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 || strs == null){
            return new ArrayList<>();
        }
        HashMap<String,List> map = new HashMap<>();
        for( String str:strs){
            System.out.println(str);
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = Arrays.toString(array);
            System.out.println(key);
            if(!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }else{
                map.get(key).add(str);
            }
        }
        return new ArrayList(map.values());

    }

}
