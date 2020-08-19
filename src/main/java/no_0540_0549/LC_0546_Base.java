package no_0540_0549;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 超时。。。
 * @author jlgc
 *
 */
public class LC_0546_Base {

	class Solution {
		public int removeBoxes(int[] boxes) {
			int[] nums = new int[101];
			for (int i = 0; i < boxes.length; i++) {
				nums[boxes[i]]++;
			}
			List<Integer> newBoxes = new ArrayList<>();
			int count = 0;
			for (int i = 0; i < boxes.length; i++) {
				if (nums[boxes[i]] == 1) {
					count++;
					continue;
				}
				newBoxes.add(boxes[i]);
			}
			boxes = new int[newBoxes.size()];
			for (int i = 0; i < newBoxes.size(); i++) {
				boxes[i] = newBoxes.get(i);
			}
			return count + removeBoxes(boxes, 0, boxes.length);
		}

		public int removeBoxes(int[] boxes, int from, int to) {
			if (from < 0 || to > boxes.length || from >= to) {
				return 0;
			}
			int[] nums = new int[101];
			int max = 0;
			for (int i = from; i < to; i++) {
				nums[boxes[i]]++;
				max = Math.max(max, nums[boxes[i]]);
			}
			
			if (max == 1) {
				// 所有数字均不同
				return to - from;
			}
			int maxv = 0;
			for (int x = 1; x < nums.length; x++) {
				if (nums[x] < 2)
					continue;

				int box = x;

				int ans = (int) Math.pow(nums[box], 2);
				int start = -1, end = -1, f = -1;
				for (int i = from; i < to; i++) {
					if (boxes[i] == box) {
						if (start == -1) {
							start = i;
						}
						end = i;
						ans += removeBoxes(boxes, f, i);
						f = i + 1;
					}
				}
				if (end - start != to - from) {
					int[] boxes2 = new int[(to - from) - (end - start + 1)];
					int idx = 0;
					if (start > from) {
						System.arraycopy(boxes, from, boxes2, idx, start - from);
						idx += start - from;
					}
					if (end < to) {
						System.arraycopy(boxes, end + 1, boxes2, idx, to - end - 1);
					}
					ans += removeBoxes(boxes2, 0, boxes2.length);
				}

				maxv = Math.max(maxv, ans);
			}

			return maxv;
		}
	}

	@Test
	@DisplayName("3")
	public void test1() {
		Solution s = new Solution();
		Assertions.assertEquals(134,
				s.removeBoxes(new int[] { 98, 83, 79, 33, 96, 72, 78, 20, 49, 27, 43, 40, 57, 37, 14, 91, 32, 63, 24, 7,
						41, 28, 98, 40, 80, 19, 41, 13, 99, 47, 76, 54, 2, 50, 95, 17, 8, 83, 12, 52, 63, 59, 63, 39, 6,
						94, 33, 5, 96, 7, 59, 90, 72, 95, 25, 45, 10, 24, 76, 81, 98, 56, 31, 67, 76, 2, 89, 25, 36, 88,
						88, 46, 46, 55, 97, 6, 15, 27, 37, 58, 6, 54, 63, 41, 42, 10, 23, 76, 13, 66, 71, 25, 82, 58,
						52, 14, 43, 83, 13, 81 }));
		Assertions.assertEquals(30,
				s.removeBoxes(new int[] { 20, 12, 2, 11, 6, 18, 4, 6, 8, 12, 16, 18, 15, 6, 10, 8, 20, 8, 15, 16 }));
		Assertions.assertEquals(180, s.removeBoxes(new int[] { 1, 1, 1, 2, 4, 8, 1, 9, 1, 2, 9, 7, 6, 3, 2, 7, 6, 5, 4,
				6, 4, 4, 2, 3, 3, 1, 7, 8, 6, 9, 1, 1, 8, 10, 1, 4, 6, 7, 7, 1, 6, 10, 7, 7, 8, 6, 1, 5, 4, 3 }));
		Assertions.assertEquals(88,
				s.removeBoxes(new int[] { 1, 4, 1, 1, 1, 3, 3, 4, 3, 1, 2, 3, 3, 3, 1, 3, 1, 3, 4, 2 }));
		Assertions.assertEquals(10, s.removeBoxes(new int[] { 3, 3, 4, 3 }));
		Assertions.assertEquals(4, s.removeBoxes(new int[] { 1, 1 }));
		Assertions.assertEquals(14, s.removeBoxes(new int[] { 1, 3, 3, 4, 3, 1 }));
		Assertions.assertEquals(23, s.removeBoxes(new int[] { 1, 3, 2, 2, 2, 3, 4, 3, 1 }));
	}

	@Test
	@DisplayName("random")
	public void random() {
		Solution s = new Solution();

		int len = 20;
		int[] boxes = new int[len];
		Random r = new Random();
		for (int i = 0; i < len; i++) {
			boxes[i] = r.nextInt(4) + 1;
			System.out.print(boxes[i] + ",");
		}
		System.out.println();
		System.out.println(s.removeBoxes(boxes));
	}

}
