package leetcode.conquer.sol.linkedlist;
import leetcode.conquer.list.ListNode;

/*
 * a quick sort a like sol that does the partition 
 * https://www.youtube.com/watch?v=K5AVJVjdmL0
 * Time O(n) Space O(1)
 */
public class PartitionList {
	public PartitionList() {}

	public ListNode partition(ListNode head, int x) {
		ListNode beforeDummy = new ListNode(0);
		ListNode before = beforeDummy;
		ListNode afterDummy = new ListNode(0);
		ListNode after = afterDummy;

		while(head != null){
			if(head.val < x){
				before.next = head;
				before = before.next;
			}else{
				after.next = head;
				after = after.next;
			}

			head = head.next;
		}

		after.next = null;
		before.next = afterDummy.next;
		return beforeDummy.next;
	}
}
