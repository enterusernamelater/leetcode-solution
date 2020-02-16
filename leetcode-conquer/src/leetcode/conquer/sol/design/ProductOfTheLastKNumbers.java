package leetcode.conquer.sol.design;

import java.util.ArrayList;
import java.util.List;


/*
 * calculating the products of the num each time the num is added to the previous products
 * if the result of the previous product is 0 we remove the product from the arr
 * Note there will only be one product of 0 in the array and its as if a num 0 is added in 
 * any other product 0 resulting from multiplication with the num will be removed right at the spot
 * Time on add the worst case is O(n) meaning no 0 products happened, get product is alwasy O(1)
 * Space O(n) 
 */
public class ProductOfTheLastKNumbers {
	
    private List<Integer> arr;
    
    public ProductOfTheLastKNumbers() {
        this.arr = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 1 && !arr.isEmpty() && arr.get(arr.size()-1) == num){
            arr.add(num);
            return;
        }
        
        for(int i=arr.size()-1;i>=0; i--){
            int val = arr.get(i)*num;
            if(val == 0) arr.remove(i);
            else arr.set(i,val);
        }
        arr.add(num);
    }
    
    public int getProduct(int k) {
        if(arr.size() < k) return 0;
        return arr.get(arr.size()-k);
    }
}
