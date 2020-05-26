package leetcode.conquer.sol.array;

/*
 * first turn integer into a char array
 * and store all chars index into a bucket marked from 0-9 (ascii)
 * then for each char left to right compare from 9 to char. if one exists and the index in the bucket
 * is greater than the current index we perform the swap between the current i and the bucket index and return
 * Time O(N) Space constant
 */
public class MaximumSwap {
	public MaximumSwap() {}
	
    public int maximumSwap(int num) {
        char[] chs = String.valueOf(num).toCharArray();
        int[] bucket = new int[10];
        
        for(int i=0;i<chs.length;i++) bucket[chs[i]-'0']=i;
        
        for(int i=0;i<chs.length;i++){
            for(int j=9;j>chs[i]-'0';j--){
                if(bucket[j]>i){
                    char tmp = chs[i];
                    chs[i] = chs[bucket[j]];
                    chs[bucket[j]] = tmp;
                    return Integer.valueOf(new String(chs));
                }
            }
        }
        
        return num;
    }
}
