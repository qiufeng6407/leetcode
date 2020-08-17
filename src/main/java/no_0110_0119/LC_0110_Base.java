package no_0110_0119;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jlgc
 *
 */
public class LC_0110_Base {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {

		public boolean isBalanced(TreeNode root) {
			Map<TreeNode, Integer> depMap = new HashMap<>();
			return isBalanced(root, depMap);
		}

		public boolean isBalanced(TreeNode root, Map<TreeNode, Integer> depMap) {
			if (root == null) {
				return true;
			}
			return (Math.abs(depth(root.left, depMap) - depth(root.right, depMap)) <= 1) && isBalanced(root.left)
					&& isBalanced(root.right);
		}

		private int depth(TreeNode root, Map<TreeNode, Integer> depMap) {
			if (root == null) {
				return 0;
			}
			if (depMap.containsKey(root)) {
				return depMap.get(root);
			}
			int leftDep = depth(root.left, depMap);
			if (root.left != null) {
				depMap.put(root.left, leftDep);
			}
			int rightDep = depth(root.right, depMap);
			if (root.left != null) {
				depMap.put(root.right, rightDep);
			}
			return Math.max(leftDep, rightDep) + 1;
		}
	}

}
