package leetcode.conquer.sol.recursion;

/*
 * dfs solution start the search on very gate.
 * time o(w*h) space is constant o(1)
 * I need to be careful on setting the base case. 
 * need to make sure that the backtracking can return to the original state with the base case
 */
public class WallsandGates {
	public WallsandGates() {}
	
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        int h = rooms.length;
        int w = rooms[0].length;
        
        for(int i=0;i<h;i++)
            for(int j=0;j<w;j++){
                if(rooms[i][j] == 0){
                    helper(rooms,i, j, h, w, 0);
                }
            }
    }
    
    private void helper(int[][] rooms, int i, int j, int h, int w, int cur){
    	//base case, when setting base case make sure that the backtrack returns to the original state.
        if(i>=h || i<0 || j>=w || j<0 || rooms[i][j] < cur) return;
        //the trick here is rooms[i][j] < cur meaning if the curr distance reaching this room 
        //is greater than the distance already recorded on the room we return
        rooms[i][j]=cur;
        helper(rooms,i+1,j,h,w,cur+1);
        helper(rooms,i-1,j,h,w,cur+1);
        helper(rooms,i,j+1,h,w,cur+1);
        helper(rooms,i,j-1,h,w,cur+1);
    }
}
