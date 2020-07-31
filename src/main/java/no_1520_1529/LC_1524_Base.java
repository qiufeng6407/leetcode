package no_1520_1529;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 写错程序了，留着万一有用
 * @author jlgc
 *
 */
@Deprecated
public class LC_1524_Base {
	class Solution {
		public int numOfSubarrays(int[] arr) {
			int[] ex = new int[100];
			for (int v : arr) {
				ex[v - 1]++;
			}
			int[] cnt = new int[2];
			for (int v : ex) {
				if (v == 0) continue;
				cnt[v % 2] = cnt[v % 2] + 1;
			}
			if (cnt[1] == 0) return 0;
			// i - j 乘积
			int l = Math.max(cnt[0], cnt[1]);
			int[][] dp = new int[l][l];
			long v = 0;
			long pow = (long) (Math.pow(10, 9) + 7);
			for (int x = 1; x <= cnt[1]; x += 2) {
				for (int y = 0; y <= cnt[0]; y++) {
					long v1 = c(cnt[1], x, dp);
					long v2 = c(cnt[0], y, dp);
					v = (v + v1 % pow + v2 % pow) % pow;
				}
			}
			System.out.println(v);
			return (int) v;
		}

		public int c(int n, int k, int[][] dp) {
			if (k == 1) {
				return n;
			}
			if (n == k) {
				return 1;
			}
			return plus(n - k + 1, n, dp) / plus(1, k, dp);
		}

		public int plus(int from, int to, int[][] dp) {
			if (dp[from - 1][to - 1] > 0)
				return dp[from - 1][to - 1];
			if (from == to) {
				dp[from - 1][to - 1] = from;
				return dp[from - 1][to - 1];
			}
			dp[from - 1][to - 1] = plus(from, to - 1, dp) * to;
			return dp[from - 1][to - 1];
		}
	}

	@Test
	public void test() {
		Solution s = new Solution();

		int[][] dp = new int[100][100];
		Assertions.assertEquals(6, s.plus(1, 3, dp));
		Assertions.assertEquals(24, s.plus(1, 4, dp));
		Assertions.assertEquals(4, s.numOfSubarrays(new int[] { 1, 3, 5 }));
	}

}
