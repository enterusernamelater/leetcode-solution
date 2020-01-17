package leetcode.conquer.sort.alg;

/*
 * insertion sort like we are play cards game, sort key val to its proper place by going backwards
 * until j reaches to the last element of the array which is the last key
 * O(N^2)
 */
public class InsertionSort {
	private int[] arr;

	public InsertionSort(int[] arr) {
		this.arr = arr;
	}

	public void insertionSort() {
		int[] arr = this.getArr();
		for(int j=1; j<arr.length; j++) {
			int key =  arr[j];
			int i = j-1;

			while(i >=0 && arr[i] > key) {
				arr[i+1] = arr[i--];
			}
			arr[i+1] = key;
		}
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}
}
