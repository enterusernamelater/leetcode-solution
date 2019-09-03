package leetcode.conquer.sol.design;

/*
 * This solution implements the Binary Index Tree algorithm. 
 * we first build the BIT with length of 1+nums.length
 * then using the formula below to add each next tree index's sum to the current num[i]'s val
 * idx + (idx & -idx)
 * when update a val on the array, its the same logic, we get the index on the tree which is i+1 
 * then we do an add on the delta of the update val and the original arr val for all next indexes of i+1 using the formula
 * above: idx + (idx & -idx)
 * when get a sum of a index i in nums arr, we sum all vals of the tree starting from i+1 all the way up to the parent.
 * to get the parent index of a index the formula is below
 * idx - (idx & -idx)
 * so to get range sum is basically getSum(j) - getSum(i) with a bit of index manipulation to fit the tree index.
 * the Time to update a index on the tree or get the sum is O(log(n)) since the worst case is traverse the height of the tree
 * Space O(N)
 * 
 * this link is the gold, please refer to this link to learn BIT
 * https://www.youtube.com/watch?v=CWDQJGaN1gY
 * Time O(log(n)) Space O(n) 
 */
public class RangeSumQueryMutable {

	private int[] tree;
	private int[] nums;

	public RangeSumQueryMutable(int[] nums) {
		this.nums = nums;
		this.tree = new int[nums.length+1];
		createBIT(nums);
	}

	private void createBIT(int[] nums){
		for(int i=1;i<tree.length;i++){
			int val = nums[i-1];
			updateTree(i,val);
		}
	}

	private void updateTree(int idx, int val){
		while(idx < tree.length){
			tree[idx] +=val;
			idx = getNext(idx);
		}
	}

	private int getNext(int idx){
		return idx + (idx & -idx);
	}

	private int getParent(int idx){
		return idx - (idx & -idx);
	}

	public void update(int i, int val) {
		updateTree(i+1,val - nums[i]);
		nums[i] = val;
	}

	public int getSum(int idx){
		int res = 0;
		while(idx > 0){
			res+=tree[idx];
			idx = getParent(idx);
		}
		return res;
	}

	public int sumRange(int i, int j) {
		return getSum(j+1) - getSum(i);
	}
}
