package no_1510_1519;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LC_1512_Base {

	class Solution {
		public int numIdenticalPairs(int[] nums) {
			int[] dp = new int[100];
			int res = 0;
			for (int i = 0; i < nums.length; i++) {
				res += dp[nums[i] - 1];
				dp[nums[i] - 1]++;
			}
			return res;
		}
	}

	@Test
	@DisplayName("test")
	public void test() {
		Solution s = new Solution();
		Assertions.assertEquals(4, s.numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 }));
		Assertions.assertEquals(6, s.numIdenticalPairs(new int[] { 1, 1, 1, 1 }));
		Assertions.assertEquals(0, s.numIdenticalPairs(new int[] { 1, 2, 3, 4 }));
	}

}
