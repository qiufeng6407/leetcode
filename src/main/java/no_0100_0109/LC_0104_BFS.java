package no_0100_0109;

import java.util.ArrayList;
import java.util.List;

public class LC_0104_BFS {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        int dep = 0;
        while (!nodes.isEmpty()) {
        	int size = nodes.size();
        	while (size > 0) {
        		TreeNode node = nodes.remove(0);
        		if (node.left != null) nodes.add(node.left);
        		if (node.right != null) nodes.add(node.right);
        		size --;
        	}
        	dep ++;
        }
        return dep;
    }
	
	class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}

}
