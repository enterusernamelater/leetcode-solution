package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import leetcode.conquer.tree.Node;

/*
 * bfs solution, only offers node to the queue if map doesnt have the node.
 * besids this,everything else is pretty much the same as any other bfs solutions.
 * Time O(n!) space O(n)
 */
public class CloneGraphBFS {
	public CloneGraphBFS() {}

	public Node cloneGraph(Node node) {
		if(node == null) return node;

		@SuppressWarnings("serial")
		Map<Integer,Node> map = new HashMap<Integer,Node>(){{
			put(node.val, new Node(node.val,new ArrayList<>()));
		}};

		Queue<Node> q = new LinkedList<>();
		q.offer(node);

		while(!q.isEmpty()){
			int size = q.size();

			for(int i=0; i<size; i++){
				Node nodeVal = q.poll();

				Node copy = map.get(nodeVal.val);

				List<Node> list = copy.neighbors;

				for(Node tmp : nodeVal.neighbors){
					if(!map.containsKey(tmp.val)) q.offer(tmp);

					Node nodeFromMap = map.getOrDefault(tmp.val, new Node(tmp.val,new ArrayList<>()));
					map.putIfAbsent(nodeFromMap.val,nodeFromMap);

					list.add(nodeFromMap);
				}

			}
		}

		return map.get(node.val);
	}
}
