package no_1520_1529;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LC_1524_Base2 {
	class Solution {
		public int numOfSubarrays(int[] arr) {
			int pow = (int) (Math.pow(10, 9) + 7);
			int count = 0;
			long[][] dp = new long[arr.length][arr.length];
			for (int i = 0; i < arr.length; i++) {
				for (int j = i; j < arr.length; j++) {
					long sum = plus(arr, i, j, dp);
					if (sum % 2 == 0) {
						continue;
					}
					count = (count + 1) % pow;
				}
			}
			return count;
		}
		
		public long plus(int[] arr, int i, int j, long[][] dp) {
			if (dp[i][j] > 0) {
				return dp[i][j];
			}
			if (i == j) {
				dp[i][j] = arr[i];
				return arr[i];
			}
			if (i > 0 && dp[i - 1][j] > 0) {
				dp[i][j] = dp[i - 1][j] - arr[i - 1];
			} else if (j < arr.length - 1 && dp[i][j + 1] > 0) {
				dp[i][j] = dp[i][j + 1] - arr[j];
			} else {
				dp[i][j] = plus(arr, i, j - 1, dp) + arr[j];
			}
			return dp[i][j];
		}
	}

	@Test
	public void test() {
		Solution s = new Solution();

		Assertions.assertEquals(4, s.numOfSubarrays(new int[] { 1, 3, 5 }));
		Assertions.assertEquals(0, s.numOfSubarrays(new int[] { 2, 4, 6 }));
		Assertions.assertEquals(16, s.numOfSubarrays(new int[] { 1,2,3,4,5,6,7 }));
		Assertions.assertEquals(4, s.numOfSubarrays(new int[] { 100,100,99,99 }));
		Assertions.assertEquals(1, s.numOfSubarrays(new int[] { 7 }));
	}

}
