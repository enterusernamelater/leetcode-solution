package leetcode.conquer.sol.array;

/*
 * form a dic using ASCII indexing then just clone the dic everything a new word is to check
 * and if a char is not in dic or used out (val ==0) break;
 * Time O(n + w*m) w is the number of words and m is the chars length
 * Space O(w*m)
 */
public class FindWordsThatCanBeFormedByCharacters {
	
	FindWordsThatCanBeFormedByCharacters(){}
	
    public int countCharacters(String[] words, String chars) {
        int[] arr = new int[26];
        for(char c : chars.toCharArray()) arr[c-'a']++;
        
        int res = 0;
        for(String s : words){
            boolean ok = true;
            //deep copy the dic arr to keep track the number of chars left
            //for the current array to form
            int[] dic = arr.clone();
            for(char c : s.toCharArray()){
                if(dic[c-'a'] == 0){
                    ok = false;
                    break;
                }
                //used
                dic[c-'a']--;
            }
            
            if(ok) res +=s.length();

        }
        
        return res;
    }
}
