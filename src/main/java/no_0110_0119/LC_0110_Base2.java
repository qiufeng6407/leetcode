package no_0110_0119;

/**
 * 
 * @author jlgc
 * 
 * 自底向上方法
 *
 */
public class LC_0110_Base2 {
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
			return depth(root) >= 0;
		}

		private int depth(TreeNode root) {
			if (root == null) {
				return 0;
			}
			int leftDep = depth(root.left);
			int rightDep = depth(root.right);
			if (leftDep == -1 || rightDep == -1 || Math.abs(rightDep - leftDep) > 1) {
				// 此节点不平衡则直接返回-1
				return -1;
			}
			return Math.max(leftDep, rightDep) + 1;
		}
	}

}
