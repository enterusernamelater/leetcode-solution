package leetcode.conquer.sol.graph;

/*               i-2
case 1 : i-1┌─┐
            └─┼─>i
             i-3
             
                i-2
case 2 : i-1 ┌────┐
             └─══>┘i-3
             i  i-4      (i overlapped i-4)

case 3 :    i-4
           ┌──┐ 
           │i<┼─┐
        i-3│ i-5│i-1
           └────┘
            i-2

*/
//this question is more about figuring out the cases above.
//Time O(n) Space O(1)
public class SelfCrossing {
	public SelfCrossing() {}

	public boolean isSelfCrossing(int[] x) {
		if(x == null || x.length == 0) return false;
		
		int n = x.length;
		for(int i=3;i<n;i++){
				//case 1:
				if(x[i] >= x[i-2] && x[i-3] >= x[i-1]) return true;
				//case 2:
				if(i>=4 && x[i]+x[i-4]>=x[i-2] && x[i-3]==x[i-1]) return true;
				//case 3:
				if(i>=5 && x[i] + x[i-4] >= x[i-2] && x[i-1] + x[i-5] >= x[i-3] && x[i-2] >= x[i-4] && x[i-3]>=x[i-1]) return true;
		}
		return false;
	}
}
