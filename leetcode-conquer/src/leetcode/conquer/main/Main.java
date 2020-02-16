
package leetcode.conquer.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * a class where I test my shit :)
 */
public class Main {
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		Collections.sort(arr, (a,b) -> a-b);
		
		char c = '0';
		System.out.println(Character.toLowerCase(c));
		String abc = "abc";
		String abd = "abd";
	}
	
	class Solution {
	    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        Queue<String> q = new LinkedList<>();
	        Set<String> set = new HashSet<>(wordList);
	        q.offer(beginWord);
	        int res = 1;
	        while(!q.isEmpty()){
	            int size = q.size();
	            res++;
	            for(int i=0;i<size;i++){
	                String base = q.poll();
	                for(String s : set){
	                    if(isValid(base,s)){
	                        if(s.equals(endWord)) return res;
	                        q.offer(s);
	                        set.remove(s);
	                    }
	                }
	            }
	        }
	        
	        return 0;
	    }
	    
	    private boolean isValid(String a, String b){
	        char[] arr1 = a.toCharArray();
	        char[] arr2 = b.toCharArray();
	        
	        int count = 0;
	        for(int i=0; i<arr1.length;i++){
	            if(arr1[i] != arr2[i]) count++;
	            if(count == 2) return false;
	        }
	        return true;
	    }
	}
	
}

