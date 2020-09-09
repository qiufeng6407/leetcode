package no_0030_0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import base.Lc;

public class Lc_0037_Base extends Lc {
	class Solution {
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			List<List<Integer>> ans = new ArrayList<List<Integer>>();
			Arrays.sort(candidates);
			combinationSum(ans, new HashSet<String>(), new int[30], candidates, target, 0);
			return ans;
		}

		public void combinationSum(List<List<Integer>> ans, Set<String> exsits, int[] countIndex, int[] candidates,
				int target, int index) {
			if (target == 0) {
				StringBuffer key = new StringBuffer();
				for (int count : countIndex) {
					key.append(count);
				}
				if (exsits.contains(key.toString())) {
					return;
				}
				List<Integer> curr = new ArrayList<>();
				for (int i = 0; i < countIndex.length; i++) {
					int count = countIndex[i];
					while (count-- > 0) {
						curr.add(candidates[i]);
					}
				}
				ans.add(curr);
				exsits.add(key.toString());
				return;
			}
			if (index >= candidates.length || candidates[index] > target) {
				return;
			}
			countIndex[index]++;
			combinationSum(ans, exsits, countIndex, candidates, target - candidates[index], index);
			countIndex[index]--;

			countIndex[index]++;
			combinationSum(ans, exsits, countIndex, candidates, target - candidates[index], index + 1);
			countIndex[index]--;

			combinationSum(ans, exsits, countIndex, candidates, target, index + 1);
		}
	}

	@Test
	public void test() {
		Solution s = new Solution();
		System.out.println(s.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
		System.out.println(s.combinationSum(new int[] { 2, 3, 5 }, 8));
		System.out.println(s.combinationSum(new int[] { 2, 3, 4 }, 8));
		System.out.println(s.combinationSum(new int[] { 48, 22, 49, 24, 26, 47, 33, 40, 37, 39, 31, 46, 36, 43, 45, 34,
				28, 20, 29, 25, 41, 32, 23 }, 69));
	}
}
