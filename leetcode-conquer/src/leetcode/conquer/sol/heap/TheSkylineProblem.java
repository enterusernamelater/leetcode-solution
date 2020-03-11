package leetcode.conquer.sol.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/*
 * the idea behind this solution is based on this link: https://www.youtube.com/watch?v=11dq8ux25oE
 * but because the solution in the link uses pq.remove which is a O(n) complexity causing the runtime to be super slow
 * I changed the way removing the height, using treeset to store the heights and a hashmap to store the box id for remove.
 * in the end the complexity decreased to O(nlog(n))
 * Space O(N)
 */
public class TheSkylineProblem {
	public TheSkylineProblem() {}

	public List<List<Integer>> getSkyline(int[][] buildings) {
		if(buildings == null || buildings.length == 0) return new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		List<Box> points = new ArrayList<>();

		//create a box with a uniqie id and the left x,y and right x,y as explained in the link
		for(int i=0;i<buildings.length;i++){
			points.add(new Box(i,new int[]{buildings[i][0], -buildings[i][2]}));
			points.add(new Box(i,new int[]{buildings[i][1], buildings[i][2]}));
		}

		//sort the box x value increasing order. special case handled see link
		Collections.sort(points, (a,b) -> a.val[0]!=b.val[0]? a.val[0] - b.val[0] : a.val[1] - b.val[1]);
		//sort the treeset when height is the same we sort the id. if dont sort the id box will not add to the set 
		//as set is a unique data structure
		TreeSet<Box> set = new TreeSet<>((a,b) -> b.val[1] == a.val[1]? a.id-b.id : b.val[1] - a.val[1]);
		Map<Integer, Box> map = new HashMap<>(); // a map to store box id to remove.
		set.add(new Box());
		int preMax = 0;

		for(Box box : points){
			if(box.val[1] < 0){
				set.add(box.inverseValue()); //inverse the left x since we added in negative
				map.put(box.id,box);//add this box to the map for later remove
			}else{
				set.remove(map.get(box.id)); //remove the box from set because now the current building is reached the end
			}

			int curMax = set.first().val[1]; // same logic as the link attached if heigh changed then we have a result point
			if(preMax != curMax){
				res.add(new ArrayList<>(Arrays.asList(box.val[0],curMax)));
				preMax = curMax;
			}
		}

		return res;
	}

	class Box{
		public int id = -1;
		public int[] val = new int[]{0,0};

		public Box(){}

		public Box(int id, int[] val){
			this.id = id;
			this.val = val;
		}

		public Box inverseValue(){
			val[1] = -val[1];
			return this;
		}
	}
}
