package no_0130_0139;

import java.util.ArrayList;
import java.util.List;

public class LC_0133_Base2 {
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
	    	Node[] visited = new Node[100];
	        return cloneGraphDfs(node, visited);
	    }

	    public Node cloneGraphDfs(Node node, Node[] visited) {
	    	if (node == null) return null;
	    	visited[node.val - 1] = new Node(node.val);
	    	node.neighbors.forEach((n) -> {
		    	if (visited[n.val - 1] == null) {
		    		visited[n.val - 1] = cloneGraphDfs(n, visited);
		    	}
		    	visited[node.val - 1].neighbors.add(visited[n.val - 1]);
	    	});
	    	return visited[node.val - 1];
	    }
	}

}
