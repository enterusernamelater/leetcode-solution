package leetcode.conquer.sol.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * This solution is based on this link below, 
 * https://www.youtube.com/watch?v=u9LE_7apB38
 * we first link all pairs result in the hashmap
 * for eg, a/b, a/c the map will be (a,{(b,val),(c,val)})
 * once the map is build we do a dfs to find the proper path from the map 
 * Time O(n!) Space O(n)
 */
public class EvaluateDivision {
	private Map<String,Map<String,Double>> map = new HashMap<>();
	private List<List<String>> equations;
	private double[] values;
	private double[] res;
	
	public EvaluateDivision() {}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		//no null as inputs are always valid
		this.equations = equations;
		this.values = values;

		buildGraph();

		this.res = new double[queries.size()];
		Arrays.fill(res,-1);

		int i = 0;
		for(List<String> q : queries){
			String a = q.get(0);
			String b = q.get(1);
			if(!map.containsKey(a) || !map.containsKey(b)){
				i++;
				continue;
			}

			dfs(a,b,1.0,i++,new HashSet<>(Arrays.asList(a)));
		}

		return res;
	}

	private void dfs(String s, String e, double tmp, int i, Set<String> used){
		if(map.get(s).containsKey(e)){
			res[i] = map.get(s).get(e)*tmp;
			return;
		}

		for(String next : map.get(s).keySet()){
			if(used.contains(next)) continue;
			used.add(next);
			dfs(next,e,map.get(s).get(next)*tmp,i,used);
		}

		used.remove(s);
	}

	private void buildGraph(){
		int i = 0;
		for(List<String> e : equations){
			String a = e.get(0);
			String b = e.get(1);
			map.putIfAbsent(a, new HashMap<>());
			map.putIfAbsent(b, new HashMap<>());
			map.get(a).put(b,values[i]);
			map.get(b).put(a,1.0/values[i]);
			map.get(a).put(a, 1.0);
			map.get(b).put(b, 1.0);
			i++;
		}
	}
}
