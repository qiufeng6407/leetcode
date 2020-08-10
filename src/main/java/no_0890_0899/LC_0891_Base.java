package no_0890_0899;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LC_0891_Base {

	class Solution {
		final int mod = 1000000007;

		public int sumSubseqWidths(int[] A) {
			if (A.length < 2) {
				return 0;
			}
			Arrays.sort(A);
			int count = 0;
			for (int i = 0; i < A.length; i++) {
				for (int j = i + 1; j < A.length; j++) {
					if (A[j] == A[i]) {
						continue;
					}
					long temp = A[j] - A[i];
					for (int x = 0; x < j - i - 1; x ++) {
						temp *= 2;
						temp %= mod;
					}
					count += temp;
					count %= mod;
				}
			}
			return count;
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
