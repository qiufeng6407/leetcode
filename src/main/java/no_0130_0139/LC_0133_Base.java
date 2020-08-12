package no_0130_0139;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_0133_Base {
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
	class Solution {
	    public Node cloneGraph(Node node) {
	    	Map<Integer, Node> visited = new HashMap<>();
	        return cloneGraphDfs(node, visited);
	    }

	    public Node cloneGraphDfs(Node node, Map<Integer, Node> visited) {
	    	if (node == null) return null;
	    	Node newNode = new Node(node.val);
	    	visited.put(node.val, newNode);
	    	node.neighbors.forEach((n) -> {
		    	if (!visited.containsKey(n.val)) {
			    	visited.put(n.val, cloneGraphDfs(n, visited));
		    	}
		    	newNode.neighbors.add(visited.get(n.val));
	    	});
	    	return newNode;
	    }
	}

}
