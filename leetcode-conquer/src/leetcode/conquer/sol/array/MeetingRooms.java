package leetcode.conquer.sol.array;

import java.util.Arrays;

/*
 * sort the meeting room by its start first and then check if we have overlap by comparing
 * the current start to the previous end
 * Time (nlogn)
 * Space constant
 */
public class MeetingRooms {
	public MeetingRooms() {}
	
    public boolean canAttendMeetings(int[][] intervals){ 
        if(intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals,(a,b) ->(a[0] == b[0]? a[1] - b[1] : a[0] - b[0]));
        
        for(int i=1;i<intervals.length;i++){
            int[] vals2 = intervals[i];
            int[] vals1 = intervals[i-1];
            if(vals2[0] < vals1[1]) return false;
        }
    
        return true;
    }
}
