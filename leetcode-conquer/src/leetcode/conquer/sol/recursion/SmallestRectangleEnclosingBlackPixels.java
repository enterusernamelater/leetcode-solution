package leetcode.conquer.sol.recursion;

/*
 * 这是一道画图题， 把上下左右的边都找到求面积就行了。
 * Time O(n*m) space constant
 */
public class SmallestRectangleEnclosingBlackPixels {
	public SmallestRectangleEnclosingBlackPixels() {}
	
	public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0) return 0;
        int top = 0, bottom = 0, left = 0, right = 0;
        int n=image[0].length, m=image.length;
        
        outer:
        for(int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                if(image[i][j] == '1'){
                    top = i;
                    break outer;
                }
            }
        }
        
        outer:
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(image[i][j] == '1'){
                    bottom = i;
                    break outer;
                }
            }
        }
        
        outer:
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(image[j][i] == '1'){
                    left = i;
                    break outer;
                }
            }
        }   
        
        outer:
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<m; j++){
                if(image[j][i] == '1'){
                    right = i;
                    break outer;
                }
            }
        }      
        
        return (bottom-top+1) * (right-left+1);
    }
}
