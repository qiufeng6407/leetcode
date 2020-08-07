package no_0100_0109;

public class LC_0100_Base {
	
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
	
	class Solution {
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	        return dfs(p, q);
	    }
	    
	    public boolean dfs(TreeNode p, TreeNode q) {
	    	if (p == null && q == null) return true;
	    	if (p == null || q == null) return false;
	    	if (p.val != q.val) return false;
	    	return dfs(p.left, q.left) && dfs(p.right, q.right);
	    }
	}

}
