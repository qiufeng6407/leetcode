package no_0340_0349;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LC_343_Base {

	/**
	 * 动态规划
	 * @author jlgc
	 *
	 */
	class Solution {
	    public int integerBreak(int n) {
	    	int[] max = new int[n];
	    	max[1] = 1;
	    	return integerBreak(max, n);
	    }
	    
	    public int integerBreak(int[] max, int n) {
	    	if (max[n - 1] != 0) return max[n - 1];
	    	for (int i = 1; i < n; i++) {
		    	max[n - 1] = Math.max(max[n - 1], Math.max(integerBreak(max, n - i) * i, (n - i) * i));
	    	}
	    	return max[n - 1];
	    }
	}
	
	/**
	 * 数学
	 * @author jlgc
	 *
	 */
	class Solution2 {
	    public int integerBreak(int n) {
	    	if (n < 4) {
	    		return n - 1;
	    	}
	    	int q = n / 3;
	    	int r = n % 3;
	    	if (r == 0) {
	    		return (int) Math.pow(3, q);
	    	} else if (r == 1) {
	    		return (int) Math.pow(3, q - 1) * 4;
	    	} else {
	    		return (int) Math.pow(3, q - 1) * 2;
	    	}
	    }
	    
	}

	@Test
	public void test() {
		Solution s = new Solution();
		Solution s2 = new Solution();
		Assertions.assertEquals(1, s.integerBreak(2));
		Assertions.assertEquals(2, s.integerBreak(3));
		Assertions.assertEquals(4, s.integerBreak(4));
		Assertions.assertEquals(36, s.integerBreak(10));
		Assertions.assertEquals(36, s2.integerBreak(10));
	}
}
