package no_0640_0649;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LC_0647_Manacher {

	class Solution {
		public int countSubstrings(String s) {
			char[] arr = new char[s.length() * 2 + 1];
			for (int i = 0; i < s.length(); i++) {
				arr[2 * i] = '#';
				arr[2 * i + 1] = s.charAt(i);
			}
			arr[arr.length - 1] = '#';
			int[] p = new int[arr.length];
			manacher(arr, p);
			int ans = 0;
			for (int i = 0; i < p.length; i++) {
				ans += p[i] / 2;
			}
			return ans;
		}

		private void manacher(char[] arr, int[] p) {
			int C = -1, R = -1;
			for (int i = 0; i < arr.length; i++) {
				boolean expand = true;
				if (i < R) {
					int j = 2 * C - i;
					int CL = C - p[C], JL = j - p[j];
					if (JL < CL) {
						p[i] = R - i;
						expand = false;
					} else if (JL > CL) {
						p[i] = p[j];
						expand = false;
					}
				}
				while (expand && i - p[i] >= 0 && i + p[i] < arr.length && arr[i - p[i]] == arr[i + p[i]]) {
					p[i]++;
				}
				if (R < p[i] + i) {
					C = i;
					R = p[i] + i;
				}
			}
		}
	}

	@Test
	@DisplayName("test1")
	public void test1() {
		Solution s = new Solution();
		Assertions.assertEquals(4, s.countSubstrings("aba"));
		Assertions.assertEquals(0, s.countSubstrings(""));
		Assertions.assertEquals(1, s.countSubstrings("a"));
		Assertions.assertEquals(3, s.countSubstrings("abc"));
		Assertions.assertEquals(6, s.countSubstrings("aaa"));
		Assertions.assertEquals(15, s.countSubstrings("aaaaa"));
	}

}
