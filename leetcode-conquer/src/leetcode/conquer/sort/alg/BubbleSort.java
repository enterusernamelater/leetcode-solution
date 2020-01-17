package leetcode.conquer.sort.alg;

/*
 * the idea of bubble sort is basically swap max to the end of the arr each time until all elements are sorted
 * o(n^2)
 */
public class BubbleSort {
	private int[] arr;

	public BubbleSort(int[] arr) {
		this.arr = arr;
	}

	public void bubbleSort() {
		int[] arr = this.getArr();
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j] > arr[j+1]) swap(j,j+1,arr);
			}
		}
	}

	private void swap(int i, int j, int[] arr) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}
}
