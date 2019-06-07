package leetcode.conquer.sol.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * this is a BFS solution referring to the link below:
 * https://www.youtube.com/watch?v=vWPCm69MSfs
 * the logic is for on every level of queue pop when starting from the beginWord
 * we keep changing the char index of the word one at a time (from 0 to word.length)
 * to any char from a to z, if the word after change matches the dict then we store to the queue 
 * and remove the match from the dict so to avoid dup. we do this on every index of the word, one index at a time
 * the loop repeats until we match the endword. of course endWord has to be in the dic so the check
 * if the changed word is in the dict will always come first before comparing to the endword 
 * time complexity o(n*26^l) where l is the length of the word and n is the length of the wordList
 * space is o(n)
 */
public class WordLadderBFS {
	public WordLadderBFS() {}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>();
		
		for(String str : wordList)
			dict.add(str);
		
		Queue<String> q = new LinkedList<>();

		q.offer(beginWord);
		int res = 0;
		
		while(!q.isEmpty()){
			res++;
			//store the size of the queue for loop
			int size = q.size();
			for (int k = 0; k<size; k++) {
				String word = q.poll();
				char[] arr = word.toCharArray();

				for(int i = 0; i<arr.length;i++){
					char c = arr[i];
					for(char j='a'; j<='z';j++){
						if(j==c) continue;
						arr[i] = j;
						String s = String.valueOf(arr);

						if(!dict.contains(s)) continue;
						
						if(s.equals(endWord)){
							System.out.println(s);
							return res+1;
						}
			
						dict.remove(s);
						q.offer(s);
					}
					arr[i] = c;
				}
			}
		}

		return 0;
	}
}
