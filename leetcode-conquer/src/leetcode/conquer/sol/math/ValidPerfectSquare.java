package leetcode.conquer.sol.math;

//"A square number is 1+3+5+7+..." is a pre-conceived knowledge. 
//Unless, we haven't heard it before, coming up with that is very rare.
public class ValidPerfectSquare {
	public ValidPerfectSquare() {}
	
    public boolean isPerfectSquare(int num) {
        int i = 1;
        
        while(num > 0){
            num-=i;
            i+=2;
        }
        
        return num == 0;
    }
}
