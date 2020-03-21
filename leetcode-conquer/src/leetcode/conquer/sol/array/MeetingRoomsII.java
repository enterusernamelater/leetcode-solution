package leetcode.conquer.sol.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * first sort the starting point of the intervals so we dont end up having gaps,
 * once a overlap is found we open another room by adding the interval to the queue
 * while keeping the earlest ending class room at the top of the queue
 * so if the next interval comes in and the earliest room is avaliable we simply update the room
 * interval to the newly added interval without creating a new room (poll and then offer)
 * Time O(nlogn)
 * Space O(n)
 */
public class MeetingRoomsII {
	public MeetingRoomsII() {}

	public int minMeetingRooms(int[][] intervals) {
		if(intervals == null || intervals.length == 0) return 0;
		Arrays.sort(intervals,(a,b) ->(a[0] == b[0]? b[1] - a[1] : a[0] - b[0]));
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);

		q.offer(intervals[0]);
		for(int i=1;i<intervals.length;i++){
			int[] vals2 = intervals[i];
			int[] vals1 = q.peek();
			if(vals2[0] >= vals1[1])q.poll();

			q.offer(vals2);
		}

		return q.size();
	}
}
