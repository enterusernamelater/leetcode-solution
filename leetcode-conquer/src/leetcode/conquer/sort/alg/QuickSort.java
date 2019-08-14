package leetcode.conquer.sort.alg;

/*
 * this is an sorting alg, quick sort
 * the partition method returns the partition index starting from the last index
 * during partition we use i and j to pointers to sort
 * i searches for any index in the current partition that is less or equal to the pivot which is always the last index of the parition
 * j follows i until the first bigger than pivot val is found then j stays at the bigger val's index ready for the next swap with the smaller val
 * than the pivot. after swap j increments it either increments to itself, or increments to the next bigger val(bigger than the pivot)
 * after the sort of the partition we return the pivot and another partition is formed with the pivot, between low to pivot index -1 and pivot index + 1 to high
 * 
 * Time O(nlog(n)) Space constant
 */
public class QuickSort {
	private int[] arr;
	public QuickSort(int[] arr) {
		this.arr = arr;
	}

	public void sort(int[] arr, int low, int high) {
		if(arr == null || arr.length == 0) return;
		int p = partition(low,high,arr);

		if(low < high) {
			sort(arr,low,p-1);
			sort(arr,p+1,high);
		}
	}

	public int partition(int low , int high, int[] arr) {
		int pivot = arr[high];

		int j = low;
		for(int i=low; i <= high; i++) {
			if(arr[i] <= pivot) {
				swap(i,j++,arr);
			}
		}

		return j-1;
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

