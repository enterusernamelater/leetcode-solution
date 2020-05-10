package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {
	public BuildAnArrayWithStackOperations() {}
	
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        
        int j=0;
        for(int i=1;i<=n && j<target.length;i++){
            if(i==target[j]){
                list.add("Push");
                j++;
            }else{
                list.add("Push");
                list.add("Pop");
            }
        }
        
        return list;
    }
}
