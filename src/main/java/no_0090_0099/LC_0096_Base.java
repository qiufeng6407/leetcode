package no_0090_0099;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LC_0096_Base {

	class Solution {
	    public int numTrees(int n) {
	    	if (n == 1) return 1;
	    	int[] dp = new int[n];
	    	dp[0] = 1;
	    	dp[1] = 2;
	    	return numTrees(n, dp);
	    }
	    
	    public int numTrees(int n, int[] dp) {
	    	if (n == 0) return 1;
	    	if (dp[n - 1] > 0) {
	    		return dp[n - 1];
	    	}
	    	int num = 0;
	    	for (int i = 1; i <= n; i++) {
	    		int left = numTrees(i - 1, dp);
	    		int right = numTrees(n - i, dp);
	    		num += left * right;
	    	}
	    	dp[n - 1] = num;
	    	return dp[n - 1];
	    }
	}

	@Test
	@DisplayName("test")
	public void test() {
		Solution s = new Solution();
		Assertions.assertEquals(5, s.numTrees(3));
	}

}
