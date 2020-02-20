package leetcode.conquer.sol.array;

public class GasStation {
	public GasStation() {}

	/*
	 * my solution, when we encounter a station we cant travel to the next (tank is smaller than the cost)
	 * we know that start from all previous sstations will end at the current station (tank is just going to get smaller)
	 * so we update the starting station to the one next the current station(current station is the station we now dont have enough gas to travel to the next)
	 * due to the logic above, when all gas stations are traversed and there is no circuitition when return -1;
	 * Time O(n)
	 * Space constant
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		for(int i=0;i<gas.length;i++){
			int tank = gas[i];
			int index = i;
			int start = i;
			while(tank >= cost[index]){
				tank -=cost[index];
				index = (++i) % gas.length;
				if(start == index) return index;
				tank += gas[index];
			}
		}
		return -1;
	}

	/*
	 * similar logic as above, when we cant travel (remain is negative) we add the negative remain to the debt. we then store the start pos one next to the current
	 * same as above logic. and continue this process to the end, note, the start position remains the same if we dont encounter a negative remain
	 * in the end if the left over remain can cover the debt from previous, the start position is a valid start poisition
	 * otherwise we return -1
	 * Time O(n)
	 * Space constant
	 */
	public int canCompleteCircuitSolTwo(int[] gas, int[] cost) {
		int debt = 0;
		int remain = 0;
		int start = 0;
		for(int i=0;i<gas.length;i++){
			remain+= gas[i]-cost[i];
			if(remain < 0){
				debt += remain;
				remain = 0;
				start = i+1;
			}
		}
		return remain+debt >= 0? start : -1;
	}
}
