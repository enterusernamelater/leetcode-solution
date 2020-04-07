package leetcode.conquer.sol.greedy;

/*
 * this is a complex recursion alg does a greedy approach the recursion base statements here are used to sort the given a,b,c
 * in a descending order so the max<=mid<=small;
 * this link has the solution explanation:
 * https://leetcode.com/problems/longest-happy-string/discuss/564277/C%2B%2BJava-a-greater-b-greater-c
 */
public class LongestHappyString {
	public LongestHappyString() {}
	
    public String longestDiverseString(int a, int b, int c) {
        return helper(a,b,c,"a","b","c");
    }
/*
 * - Case 1: a > 0, b = 0, c = 0: now you only have the chance to escape min(a, 2) cards, 
 * otherwise you break the 3-card-in-a-row rule;
 * - Case 2: a >= b >= 1, c whatever: now you have to escape min(a, 2) number of 'a'cards first. 
 * After that, check if a >= b is satisfied, then you can follow another 'b' here. 
 * However, if a < b please don't escape 'b'. The reason is that if you do so, 
 * in the next round 'b' would be the one with the largest number (a simple proof: b > a && b >=c), 
 * then you'll get risk breaking the 3-card-in-a-row rule.
 */
    private String helper(int a, int b, int c, String aa, String bb, String cc){
        if(a<b) return helper(b,a,c,bb,aa,cc);
        if(b<c) return helper(a,c,b,aa,cc,bb);
        if(b==0) return aa.repeat(Math.min(2,a)); // there is no more cushion this is the last max 2 'a' to add
        int usea = Math.min(2,a), useb = a-usea>=b? 1:0;
        return aa.repeat(usea) + bb.repeat(useb) + helper(a-usea,b-useb,c,aa,bb,cc);
    }
}
