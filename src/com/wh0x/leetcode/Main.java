package com.wh0x.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        HashSet<String> set = new HashSet<>(list);
        System.out.println(set.contains("a"));
    }
}
