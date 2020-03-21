package leetcode.conquer.sol.array;

/*
 * handling on two cases, first we two words are the same then we basically loop through the words
 * find the distance between any identical non overlapped words
 * if word1 and word2 not the same, we use two int vals to store word1 and word2 index and finding their differences
 * while loop the words list. 
 * above calcuation a MIN in maintained the whole time.
 * O(n)
 * Space constant
 */
public class ShortestWordDistanceIII {
	public ShortestWordDistanceIII() {}

	public int shortestWordDistance(String[] words, String word1, String word2) {
		if(words == null || words.length == 0) return 0;
		int res = Integer.MAX_VALUE;
		if(word1.equals(word2)){
			int i=0;
			for(int j=1;j<words.length;j++){
				if(words[j].equals(word1) && words[i].equals(word1)) res = Math.min(j-i,res);
				if(words[j].equals(word1)) i=j;
			}
		}else{
			int w1 =0;
			int w2 = 0;
			for(int i=0;i<words.length;i++){
				if(words[i].equals(word1)) w1 = i;
				if(words[i].equals(word2)) w2 = i;
				if(words[w1].equals(word1) && words[w2].equals(word2)) res = Math.min(Math.abs(w2-w1),res);
			}
		}

		return res;
	}
	
	/*
	 * brute force, finding the next word after first word is found, the found word can be either word1 or word2
	 * once the second found we break the loop as we do not care any words further because will ended up having a longer
	 * distance
	 * Time O(n^2)
	 * space constant
	 */
    public int shortestWordDistanceMySol(String[] words, String word1, String word2) {
        if(words == null || words.length ==0) return 0;
        boolean found1 = false, found2=false;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)) found1 = true;
            else if(words[i].equals(word2)) found2 = true;
            else continue;
            for(int j=i+1;j<words.length;j++){
                if(found1 && words[j].equals(word2) || found2 && words[j].equals(word1)){
                    res = Math.min(res, Math.abs(j-i));
                    break;
                }
            }
            found1 = false; found2 = false;
        }
        
        return res;
    }
}
