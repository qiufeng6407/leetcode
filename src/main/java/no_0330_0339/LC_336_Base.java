package no_0330_0339;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 337. 打家劫舍 III
 * @author jlgc
 *
 */
public class LC_336_Base {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public int rob(TreeNode root) {
			int[] rootStatus = dfs(root);
			return Math.max(rootStatus[0], rootStatus[1]);
		}
		
		public int[] dfs(TreeNode root) {
			if (root == null) {
				return new int[] { 0, 0 };
			}
			int[] lStatus = dfs(root.left);
			int[] rStatus = dfs(root.right);
			
			int[] cStatus = new int[2];
			// 当前节点选中，则总数=当前节点值+左节点未选中的值+右节点未选中的值
			cStatus[0] = root.val + lStatus[1] + rStatus[1]; 
			// 当前节点未选中，则总数=max(左节点未选中的值, 左节点选中的值)+max(右节点未选中的值, 右节点选中的值)
			cStatus[1] = Math.max(lStatus[0], lStatus[1]) + Math.max(rStatus[0], rStatus[1]);
			return cStatus;
		}
	}

	@Test
	@DisplayName("3")
	public void test1() {
		
	}


}