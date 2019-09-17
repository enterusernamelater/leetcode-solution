package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * this is the merge sort solution using merge sort indexing on the lists
 * and use merge two list method to merge two lists
 * code is pretty self explanatory.
 * Time O(n*klog(n)) where n is the lists size k is the max node size.
 * Space constant
 */
public class MergeKSortedListsMergeSortSol {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		return mergeKLists(lists, 0, lists.length - 1);
	}

	private ListNode mergeKLists(ListNode[] lists, int start, int end) {
		if (start == end) {
			return lists[start];
		} else if (start < end){
			int mid = (end - start) / 2 + start;
			ListNode left = mergeKLists(lists, start, mid);
			ListNode right = mergeKLists(lists, mid + 1, end);
			return mergeTwoList(left, right);
		} else {
			return null;
		}
	}
	
	private ListNode mergeTwoList(ListNode one, ListNode two){
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(one != null && two != null){
			if(one.val > two.val){
				tail.next = new ListNode(two.val);
				two = two.next;
			}else{
				tail.next = new ListNode(one.val);
				one = one.next;
			}
			tail = tail.next;
		}

		while(one != null){
			tail.next = new ListNode(one.val);
			one = one.next;
			tail = tail.next;
		}

		while(two != null){
			tail.next = new ListNode(two.val);
			two = two.next;
			tail = tail.next;
		}

		return dummy.next;
	}
}
