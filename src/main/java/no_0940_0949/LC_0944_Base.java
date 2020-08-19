package no_0940_0949;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LC_0944_Base {

	class Solution {
		public int minDeletionSize(String[] A) {
			if (A.length < 1) {
				return 0;
			}
			int count = 0;
			for (int j = 0; j < A[0].length(); j++) {
				for (int i = 1; i < A.length; i++) {
					if (A[i].charAt(j) < A[i - 1].charAt(j)) {
						count++;
						break;
					}
				}
			}
			return count;
		}
	}

	@Test
	@DisplayName("test1")
	public void test1() {
		Solution s = new Solution();
		Assertions.assertEquals(3, s.minDeletionSize(new String[] { "zyx", "wvu", "tsr" }));
		Assertions.assertEquals(0, s.minDeletionSize(new String[] { "a", "b" }));
		Assertions.assertEquals(1, s.minDeletionSize(new String[] { "cba", "daf", "ghi" }));
		Assertions.assertEquals(0, s.minDeletionSize(new String[] { "abcdef", "uvwxyz" }));
		Assertions.assertEquals(0, s.minDeletionSize(new String[] { "", "" }));
		Assertions.assertEquals(0, s.minDeletionSize(new String[] { "" }));
		Assertions.assertEquals(0, s.minDeletionSize(new String[] { }));
	}

}
