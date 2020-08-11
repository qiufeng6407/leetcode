package no_1140_1149;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LC_1144_Base {

	class Solution {
		public int movesToMakeZigzag(int[] nums) {
			int[] cnt = new int[2];
			for (int i = 0; i < nums.length; i += 1) {
				int min = 1001;
				if (i > 0) min = nums[i - 1];
				if (i + 1 < nums.length) min = Math.min(min, nums[i + 1]);
				if (nums[i] >= min) cnt[i & 1] += nums[i] - min + 1;
			}
			return Math.min(cnt[0], cnt[1]);
		}
	}

	@Test
	@DisplayName("test")
	public void test() {
		Solution s = new Solution();
		Assertions.assertEquals(0, s.movesToMakeZigzag(new int[] {}));
		Assertions.assertEquals(2, s.movesToMakeZigzag(new int[] { 1, 2, 3 }));
		Assertions.assertEquals(4, s.movesToMakeZigzag(new int[] { 9, 6, 1, 6, 2 }));
	}

	@Test
	@DisplayName("test2")
	public void test2() {
		Solution s = new Solution();
		Random r = new Random();
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = r.nextInt(100) + 1;
			System.out.print(String.format("%d, ", nums[i]));
		}
		System.out.println();
		System.out.println(s.movesToMakeZigzag(nums));
	}

}
