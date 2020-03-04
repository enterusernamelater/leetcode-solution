package leetcode.conquer.sol.topsort;

import java.util.ArrayList;
import java.util.List;

/*
 * a very similar solution to the courseschedule one sol
 * only difference is we use an arr res to add the res when we flip a node to visited
 * Time O(n), Space O(n)
 */
public class CourseScheduleII {
	private int[] res;
	private int index; 
	public int[] findOrder(int numCourses, int[][] prerequisites) {

		//initialize
		this.res = new int[numCourses];

		List<List<Integer>> table = new ArrayList<>();
		for(int i=0; i<numCourses;i++){
			table.add(new ArrayList<>());
		}

		for(int i=0; i<prerequisites.length;i++){            
			table.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}

		int[] v = new int[numCourses];

		for(int i=0;i<numCourses;i++){
			if(dfs(table,v,i)){
				return new int[0];
			}
		}

		return res;
	}

	private boolean dfs(List<List<Integer>> table, int[] v, int course){
		if(v[course] == 1) return false;
		if(v[course] == 2) return true;

		v[course] = 2;
		for(int i : table.get(course)){
			if(dfs(table,v,i)) return true;
		}

		res[index++] = course;
		v[course] = 1;
		return false;
	}
	
	//instead of using a fancy primitive int[] I used an arraylist and convert to primitive after
    public int[] findOrderMySol(int n, int[][] prerequisites) {
        int[] v = new int[n]; // 1 is visiting, 2 is visited
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<>());

        for(int[] pair : prerequisites){
            List<Integer> val = list.get(pair[0]);
            val.add(pair[1]);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!helper(i,res,list,v)) return new int[0];
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private boolean helper(int curr, List<Integer> res,  List<List<Integer>> list, int[] v){
        if(v[curr] == 1) return false;
        if(v[curr] == 2) return true;
        
        v[curr] = 1; // visiting
        List<Integer> arr = list.get(curr);
        for(int val : arr){
            if(!helper(val,res,list,v)) return false;
        }
        res.add(curr);
        v[curr] = 2;
        return true;
    }
}
