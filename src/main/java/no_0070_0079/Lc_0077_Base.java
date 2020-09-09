package no_0070_0079;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Lc_0077_Base {
	class Solution {
		public List<List<Integer>> combine(int n, int k) {
			List<List<Integer>> ans = new ArrayList<List<Integer>>();
			combine(ans, new ArrayList<Integer>(), 1, n, k);
			return ans;
		}
		
		public void combine(List<List<Integer>> ans, List<Integer> curr, int from, int to, int k) {
			if (k == 0) {
				ans.add(new ArrayList<>(curr));
				return;
			}
			if (from > to) {
				return;
			}
			curr.add(from);
			combine(ans, curr, from + 1, to, k - 1);
			curr.remove(curr.size() - 1); // 回溯
			if (to - from + 1 >= k) { // 当前数不取，剩下数足够
				combine(ans, curr, from + 1, to, k);
			}
		}
	}
	
	
	@Test
	public void test() {
		Solution s = new Solution();
		System.out.println(s.combine(4, 1));
		System.out.println(s.combine(4, 2));
		System.out.println(s.combine(4, 3));
		System.out.println(s.combine(4, 4));
	}
}
