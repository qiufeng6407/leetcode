package no_0340_0349;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class LC_347_Base {

	private class St {
		int num;
		int count;
		public St(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}
	class Solution {
		public int[] topKFrequent(int[] nums, int k) {
			Map<Integer, Integer> count = new HashMap<>();
			for (int num : nums) {
				count.put(num, count.getOrDefault(num, 0) + 1);
			}
			List<St> l = count.entrySet().stream().map(e->{
				return new St(e.getKey(), e.getValue());
			}).sorted(Comparator.comparingInt(e->{ return e.count; })).collect(Collectors.toList());

			int[] ans = new int[k];
			for (int i = 0; i < ans.length; i++) {
				ans[i] = l.get(l.size() - i - 1).num;
//				System.out.print(ans[i] + " ");
			}
//			System.out.println();
			return ans;
		}
	}

	@Test
	public void test() {
		Solution s = new Solution();
		s.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
		s.topKFrequent(new int[] { 1 }, 1);
	}
}
