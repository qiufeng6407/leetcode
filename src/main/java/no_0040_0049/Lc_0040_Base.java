package no_0040_0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import base.Lc;

public class Lc_0040_Base extends Lc {
	class Solution {
		public List<List<Integer>> combinationSum2(int[] candidates, int target) {
			Arrays.sort(candidates);
			List<List<Integer>> ans = new ArrayList<List<Integer>>();
			List<int[]> freq = new ArrayList<int[]>();
			for (int candidate : candidates) {
				if (freq.isEmpty() || candidate != freq.get(freq.size() - 1)[0]) {
					freq.add(new int[] { candidate, 1 });
				} else {
					freq.get(freq.size() - 1)[1]++;
				}
			}
			combinationSum(ans, new ArrayList<Integer>(), freq, target, 0);
			return ans;
		}

		public void combinationSum(List<List<Integer>> ans, List<Integer> curr, List<int[]> freq, int target, int index) {
			if (target == 0) {
				ans.add(new ArrayList<Integer>(curr));
				return;
			}
			if (index >= freq.size() || freq.get(index)[0] > target) {
				return;
			}
			
			combinationSum(ans, curr, freq, target, index + 1);
			
			int candidate = freq.get(index)[0];
			int count = freq.get(index)[1];
			for (int i = 1; i <= count && target >= i * candidate; i++) {
				curr.add(candidate);
				combinationSum(ans, curr, freq, target - i * candidate, index + 1);
			}
			for (int i = 1; i <= count && target >= i * candidate; i++) {
				curr.remove(curr.size() - 1);
			}
		}
	}

	@Test
	public void test() {
		Solution s = new Solution();
		System.out.println(s.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
		System.out.println(s.combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5));
	}
}
