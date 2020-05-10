package leetcode.conquer.sol.array;

/*
 * first we find the bulls and exclude them
 * then we find the matches
 * Time O(n)
 * space constant
 */
public class BullsAndCows {
	public BullsAndCows() {}
	
    public String getHint(String secret, String guess) {
        char[] sarr = secret.toCharArray();
        char[] garr = guess.toCharArray();
        
        int a = 0; //bull
        int b = 0; //cow
        for(int i=0;i<garr.length;i++){
            if(sarr[i]==garr[i]){
                a++;
                sarr[i]='x';
                garr[i]='x';
            }
        }
        
        int[] arr = new int[10];
        for(char c : sarr) if(c != 'x')arr[c-'0']++;
        
        for(int i=0;i<garr.length;i++){
            if(garr[i] == 'x') continue;
            if(arr[garr[i] - '0'] > 0){
                b++;
                arr[garr[i] - '0']--;
            }
        }
        
        return a + "A" + b + "B";
    }
}
