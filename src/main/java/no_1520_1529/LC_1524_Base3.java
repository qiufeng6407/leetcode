package no_1520_1529;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LC_1524_Base3 {
	class Solution {
		public int numOfSubarrays(int[] arr) {
			int mod = (int) (Math.pow(10, 9) + 7);
			int res = 0, cur = 0;
			int[] x = new int[2];
			x[0] = 1;
			for (int i = 0; i < arr.length; i++) {
				cur = (cur + arr[i]) % 2;
				res += x[1 - cur];
				x[cur]++;
				res %= mod;
				
			}
			return res % mod;
		}
	}

	@Test
	public void test() {
		Solution s = new Solution();

		Assertions.assertEquals(4, s.numOfSubarrays(new int[] { 1, 3, 5 }));
		Assertions.assertEquals(0, s.numOfSubarrays(new int[] { 2, 4, 6 }));
		Assertions.assertEquals(16, s.numOfSubarrays(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
		Assertions.assertEquals(4, s.numOfSubarrays(new int[] { 100, 100, 99, 99 }));
		Assertions.assertEquals(1, s.numOfSubarrays(new int[] { 7 }));
	}

}
