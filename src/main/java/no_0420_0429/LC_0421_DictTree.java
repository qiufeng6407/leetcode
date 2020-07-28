package no_0420_0429;

/**
 * 421. 数组中两个数的最大异或值
 * @author jlgc
 *
 */
public class LC_0421_DictTree {
	
	private class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
	}

    public int findMaximumXOR(int[] nums) {
    	if (nums.length < 2) return 0;
    	if (nums.length == 2) return nums[0] ^ nums[1];
    	int max = nums[0];
		for (int i = 1; i < nums.length; i++) max = Math.max(max, nums[i]);
		int maxLen = Integer.toBinaryString(max).length();
    	TreeNode root = new TreeNode();
    	
    	for (int num : nums) {
    		TreeNode parent = root;
    		for (int i = maxLen - 1; i >= 0; i--) {
    			if ((num >> i & 1) == 0) {
    				if (parent.left == null) {
    					parent.left = new TreeNode();
    				}
    				parent = parent.left; 
    			} else {
    				if (parent.right == null) {
    					parent.right = new TreeNode();
    				}
    				parent = parent.right; 
    			}
    		}
    		parent.val = num;
    	}
		int maxXor = 0;
		for (int num : nums) {
			TreeNode parent = root;
			for (int i = maxLen - 1; i >= 0; i--) {
				if ((num >> i & 1) == 0) {
					if (parent.right != null) {
						parent = parent.right;
					} else {
						parent = parent.left;
					}
				} else {
					if (parent.left != null) {
						parent = parent.left;
					} else {
						parent = parent.right;
					}
				}
			}
			maxXor = Math.max(maxXor, parent.val ^ num);
		}
		return maxXor;
    }

	public static void main(String[] args) {
		LC_0421_DictTree lc = new LC_0421_DictTree();

		System.out.println(lc.findMaximumXOR( new int[] { 3, 10, 5, 25, 2, 8 }));

	}

}
