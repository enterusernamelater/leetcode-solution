package leetcode.conquer.sol.rand;

import java.util.Random;

/*
 * use swap to achieve an random array, when swap we randIndex one of the index the randIndex method is pretty
 * self explanatory. use deep copy to keep a original and a copy cat
 * 
 * Time O(n) space O(n)
 */
public class ShuffleAnArray {
    private int[] arr;
    private int[] ori;
    
    private Random rand = new Random();
    
    public ShuffleAnArray(int[] nums) {
        this.ori = nums;
        this.arr = ori.clone();
    }
    
    private void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    private int randIndex(int min,int max){
        return min + rand.nextInt(max-min);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.arr = this.ori.clone();
        return this.arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=0;i<this.arr.length;i++){
            swap(i , randIndex(i,this.arr.length));
        }
        
        return this.arr;
    }
}
