package com.wh0x.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode-cn.com/problems/word-ladder/
 * leetcode 127
 * 思路:bfs 将所有能够转化的节点入队同时remove代表已经访问过，每过一层加1
 * Time:O(2^h)
 * Space:O(2^h) h 树的高度
 */
public class LadderLengthSolution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord))
            return 0;
        int result = 0;
        int length = beginWord.length();
        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String tmp = queue.pollFirst();
                if(tmp.toString().equals(endWord))
                    return result;
                for (int j = 0; j < length; j++) {
                    for (char c = 'a';c <= 'z';c++){
                        String s = tmp.substring(0,j) + c + tmp.substring(j+1,length);
                        if(set.contains(s)){
                            queue.add(s);
                            set.remove(s);
                        }
                    }
                }
            }
            result++;
        }
        return 0;
    }
}
