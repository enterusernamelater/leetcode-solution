package leetcode.conquer.sol.design;

import java.util.HashMap;
import java.util.Map;

/*
 * store all locations id and start/end time in map 
 * then when calculating the average time of a location
 * take out the location from the end time location map and the start time location map
 * find the average on the same user id appears in both maps. if the user id is missing in the start time 
 * location map meaning the user is boarded from somewhere else we continue
 */
public class UndergroundSystem {
	public Map<String,Map<Integer,Integer>> checkin = new HashMap<>();
	public Map<String,Map<Integer,Integer>> checkout = new HashMap<>();
	
	public UndergroundSystem() {

	}

	public void checkIn(int id, String stationName, int t) {
		Map<Integer,Integer> map = checkin.getOrDefault(stationName, new HashMap<>());
		map.put(id,t);
		checkin.putIfAbsent(stationName, map);
	}

	public void checkOut(int id, String stationName, int t) {
		Map<Integer,Integer> map = checkout.getOrDefault(stationName, new HashMap<>());
		map.put(id,t);
		checkout.putIfAbsent(stationName, map);
	}

	public double getAverageTime(String startStation, String endStation) {
		Map<Integer,Integer> map1 = checkin.get(startStation);
		Map<Integer,Integer> map2 = checkout.get(endStation);
		if(map2 == null || map2.isEmpty()) return 0.0;
		double sum = 0;
		double count = 0;
		for(int val : map2.keySet()){
			if(map1.get(val) == null) continue; // the user is boarded somewhere else.
			int start = map1.get(val);
			int end = map2.get(val);
			sum += (end-start);
			count++;
		}

		return sum/count;
	}
}
