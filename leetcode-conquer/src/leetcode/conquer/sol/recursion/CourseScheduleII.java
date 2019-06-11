package leetcode.conquer.sol.recursion;

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
}
