package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * no point explain..a detailed sol link can be find in here:
 * https://www.youtube.com/watch?v=esl_A_pzBcg
 * Time O(N) Space O(1)
 */
public class ReverseLinkedListII {
	public ReverseLinkedListII() {}

	/*
	 * pretty much the same solution as the reverse linkedlist question only a little different on the
	 * searching interval on the given starting m and ending n
	 * after we finish reversing, we just need to reconnect.
	 * see comment below on how to reconnect
	 */
	public ListNode reverseBetweenMySol(ListNode head, int m, int n) {
		if(head == null || head.next == null) return head;
		ListNode root = new ListNode(0);
		root.next = head;
		ListNode prev = root;

		for(int i=1;i<m;i++)
			prev = prev.next;

		int len = n-m+1;
		ListNode cur = prev.next;
		//this end reference follows cur until the end we will connect the end to the following linked list
		ListNode end = cur;

		for(int i=len;i>0;i--){
			ListNode tmp = cur.next;
			cur.next = prev.next;
			prev.next = cur;
			cur = tmp;
		}

		//end is the refernce copy to the first node to reverse. the first node will be the ending. we then reconnect.
		end.next = cur;

		return root.next;
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev =dummy;
		ListNode mNode=head;
		ListNode nNode=head;

		for(int i=1;i<m;i++){
			prev = mNode;
			mNode = mNode.next;
		}

		for(int i=1;i<n;i++){
			nNode = nNode.next;
		}

		while(mNode != nNode){
			prev.next = mNode.next;
			mNode.next = nNode.next;
			nNode.next = mNode; 
			mNode = prev.next;
		}
		return dummy.next;
	}
	
    public ListNode reverseBetweenMySolTwo(ListNode head, int m, int n) {       
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy.next;
        ListNode pre = dummy;
        
        pre.next = start;
        for(int i=1;i<m;i++){
            pre = pre.next;
            start = start.next;
        }
        
        for(int i=0; i<n-m; i++){
            ListNode save = start.next;
            start.next= start.next.next;
            
            save.next = pre.next;
            pre.next = save;
        }
        
        return dummy.next;
        
    }
}
