package no_0890_0899;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LC_0891_Base2 {

	class Solution {
		final int mod = 1000000007;

		public int sumSubseqWidths(int[] A) {
			if (A.length < 2) {
				return 0;
			}
			Arrays.sort(A);
			long[] pow2 = new long[A.length];
			pow2[0] = 1;
			for (int i = 1; i < A.length; i++) {
				pow2[i] = (pow2[i - 1] * 2) % mod;
			}
			long count = 0;
			for (int i = 0; i < A.length; i++) {
				count = (count + (pow2[i] - pow2[A.length - i - 1]) * A[i]) % mod;
			}
			return (int) count;
		}
	}

	@Test
	@DisplayName("test")
	public void test() {
		Solution s = new Solution();
		Assertions.assertEquals(0, s.sumSubseqWidths(new int[] {})); // 1, 2, 3
		Assertions.assertEquals(6, s.sumSubseqWidths(new int[] { 2, 1, 3 })); // 1, 2, 3
		Assertions.assertEquals(14, s.sumSubseqWidths(new int[] { 2, 1, 3, 2 })); // 1, 2, 2, 3
		Assertions.assertEquals(56970, s.sumSubseqWidths(new int[] { 1, 2, 3, 4, 5, 6, 7, 9, 9, 9, 9, 9, 9 }));
		Assertions.assertEquals(857876214,
				s.sumSubseqWidths(new int[] { 5, 69, 89, 92, 31, 16, 25, 45, 63, 40, 16, 56, 24, 40, 75, 82, 40, 12, 50,
						62, 92, 44, 67, 38, 92, 22, 91, 24, 26, 21, 100, 42, 23, 56, 64, 43, 95, 76, 84, 79, 89, 4, 16,
						94, 16, 77, 92, 9, 30, 13 }));
	}

}
