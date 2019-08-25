package leetcode.conquer.sol.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * use a map to track each users transaction and do compare on the city and the time if a transaction
 * happened to be on the same user, this means the map contains the user's name
 * Time O(n) Space O(n)
 */
public class InvalidTransactions {
	public InvalidTransactions() {}
	
	private Map<String,Set<String[]>> map = new HashMap<>();
	
	public List<String> invalidTransactions(String[] t) {
		if(t == null || t.length == 0) return new ArrayList<>();
		Set<String> res = new HashSet<>();

		for(String str : t){
			String[] vals = str.split(",");
			String name = vals[0];
			Integer time = Integer.valueOf(vals[1]);
			Integer amount = Integer.valueOf(vals[2]);
			String city = vals[3];

			if(amount > 1000) res.add(str);

			if(map.containsKey(name)){
				Set<String[]> arr = map.get(name);
				for(String[] rec : arr){
					if(!rec[3].equals(city) && Math.abs(Integer.valueOf(rec[1]) - time) <= 60){
						if(!res.contains(str)){
							res.add(str);
						}

						String invalid = rec[0]+","+rec[1]+","+rec[2]+","+rec[3];

						if(!res.contains(invalid)){
							res.add(invalid);
						}
					}
				}
			}

			Set<String[]> set = map.getOrDefault(name, new HashSet<>());
			set.add(vals);
			map.putIfAbsent(name,set);
		}

		return new ArrayList<>(res);
	}
}
