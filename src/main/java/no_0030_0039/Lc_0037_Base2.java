package no_0030_0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import base.Lc;

public class Lc_0037_Base2 extends Lc {
	class Solution {
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			List<List<Integer>> ans = new ArrayList<List<Integer>>();
			Arrays.sort(candidates);
			combinationSum(ans, new ArrayList<Integer>(), candidates, target, 0);
			return ans;
		}

		public void combinationSum(List<List<Integer>> ans, List<Integer> curr, int[] candidates, int target, int index) {
			if (target == 0) {
				ans.add(new ArrayList<Integer>(curr));
				return;
			}
			if (index >= candidates.length || candidates[index] > target) {
				return;
			}
			combinationSum(ans, curr, candidates, target, index + 1);
			
			curr.add(candidates[index]);
			combinationSum(ans, curr, candidates, target - candidates[index], index);
			curr.remove(curr.size() - 1);
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
