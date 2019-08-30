package leetcode.conquer.sol.design;

/*
 * This question is basically a loop on 2d array..just need to handle a spacial case when a row has empty arr. In this case, we skip.
 * Time O(1) on one hit, total O(n)
 * Space O(n)
 */
public class Flatten2DVector {
    private int[][] v;
    private int i;
    private int j;
    public Flatten2DVector(int[][] v) {
        this.i=0;
        this.j=0;
        this.v = v;
    }
    
    public int next() {
        //special case when given v has a row with empty arr
        //when need to skip based on the question.
        while(i<v.length && v[i].length == 0) i++;
        int res = v[i][j];
        if(j<v[i].length-1) j++;
        else if(i<v.length){
            j=0;
            i++;
        }
        return res;
    }
    
    public boolean hasNext() {
        //its possible that when i is at a row that is less than the total row length 
        //but the col length for the row is empty
        //same like the next() we need to skip empty rows.
        while(i<v.length && v[i].length == 0) i++;
        return i<v.length && j<v[i].length;
    }
}
