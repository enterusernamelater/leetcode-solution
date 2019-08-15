package leetcode.conquer.sort.alg;

/*
 * this is a merge sort solution that we first divide and conquer to the first two and second two and move up through the alg
 * once two parts are mergesorted, we move up to its previous mid through recursion and sort and combine both parts
 * Time O(nlog(n)) Space O(n)
 */
public class MergeSort {
	private int[] arr;

	public MergeSort(int[] arr) {
		this.arr = arr;
	}

	public void sort(int l, int r) {
		if(l<r) {
			int mid = (l+r) >> 1;

		sort(l, mid); // mid is inclusive
		sort(mid+1, r);

		merge(l,r,mid);
		}
	}


	public void merge(int l, int r, int mid) {
		int n1 = mid - l +1; //+1 is plus mid;
		int n2 = r-mid;

		int[] arr1 = new int[n1];
		for(int i=0;i<n1;i++) arr1[i] = arr[l+i];

		int[] arr2 = new int[n2];
		for(int i=0;i<n2;i++) arr2[i] = arr[mid + i + 1];

		int i = l;
		int i1 = 0;
		int i2 = 0;
		while(i1<n1 && i2< n2) {
			if(arr1[i1] > arr2[i2]) {
				arr[i++] = arr2[i2++];
			}else {
				arr[i++] = arr1[i1++];
			}
		}

		while(i1<n1) arr[i++] = arr1[i1++];
		while(i2<n2) arr[i++] = arr2[i2++];

		return;
	}
	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}
}
