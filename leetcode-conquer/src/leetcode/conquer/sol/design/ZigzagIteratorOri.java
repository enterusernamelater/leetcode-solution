package leetcode.conquer.sol.design;

import java.util.List;

/*
 * two index increment one at time on each arr until both reaches the end
 * Time o(N) space o(n)
 */
public class ZigzagIteratorOri {
    private List<Integer> v1;
    private List<Integer> v2;
    //i for v1 j for v2
    int i = 0, j = 0;
    public ZigzagIteratorOri(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if(i >= v1.size()) return v2.get(j++);
        if(j >= v2.size()) return v1.get(i++);
        if(i>j){
            return v2.get(j++);
        }else{
            return v1.get(i++);
        }
    }

    public boolean hasNext() {
        return i<v1.size() || j<v2.size();
    }
}
