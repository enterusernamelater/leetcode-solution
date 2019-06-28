package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * first we find the longest list and the delta size between the two list
 * we then cut the longest list to equal to the short list
 * then we start the two equal size list in a while loop and search for a node that equals each other in the two list
 * if found we return the node, otherwise we return null.
 * Time O(n), Space O(1)
 */
public class IntersectionOfTwoLinkedLists {
	public IntersectionOfTwoLinkedLists(){}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int sizeA = 0;
		int sizeB = 0;

		ListNode curA = headA;
		ListNode curB = headB;

		while(curA != null){
			sizeA++;
			curA = curA.next;
		}

		while(curB != null){
			sizeB++;
			curB = curB.next;
		}

		boolean startA = sizeA>sizeB;
		ListNode startANode = headA;
		ListNode startBNode = headB;

		if(startA){
			int diff = sizeA - sizeB;
			while(diff>0){
				startANode = startANode.next;
				diff--;
			}
		}else{
			int diff = sizeB-sizeA;
			while(diff>0){
				startBNode = startBNode.next;
				diff--;
			}
		}

		while(startANode != null && startBNode != null){
			if(startANode == startBNode){
				return startANode;
			}
			startANode = startANode.next;
			startBNode = startBNode.next;
		}

		return null;
	}
}
