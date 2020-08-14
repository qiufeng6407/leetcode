package no_0520_0529;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author jlgc
 *
 */
public class LC_0522_Base {

	class Solution {
		public int findLUSlength(String[] strs) {
			Arrays.sort(strs, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() != o2.length()) {
						return o1.length() - o2.length();
					}
					return o1.compareTo(o2);
				}
			});
			
			int[] flag  = new int[strs.length];
			Set<String> pre = new HashSet<>();
			int i = strs.length - 1;
			while (i >= 0) {
				if (flag[i] == 1 || contains(strs[i], pre)) {
					flag[i] = 1;
					i--;
					continue;
				}
				if (i == 0 || strs[i].length() > strs[i - 1].length()) {
					return strs[i].length();
				}
				if (strs[i].equals(strs[i - 1])) {
					pre.add(strs[i]);
					flag[i] = 1;
					flag[i - 1] = 1;
					i -= 2;
					continue;
				}
				return strs[i].length();
			}
			return -1;
		}
		
		private boolean contains(String str, Set<String> pre) {
			for (String p : pre) {
				int i = 0, j = 0;
				while (j < p.length()) {
					if (str.charAt(i) == p.charAt(j)) {
						if (i == str.length() - 1) {
							return true;
						}
						i++;
					}
					j++;
				}
			}
			return false;
		}
	}

	@Test
	@DisplayName("3")
	public void test1() {
		Solution s = new Solution();
		Assertions.assertEquals(-1, s.findLUSlength(new String[] { "aba", "abe", "abc", "abcde", "abcde", "ababab", "ababab", "ababab" }));
		Assertions.assertEquals(3, s.findLUSlength(new String[] { "aba", "abe", "abc", "abcde", "abcde", "abcde" }));
		Assertions.assertEquals(3, s.findLUSlength(new String[] { "aba", "abe", "abc", "abcde", "abcde" }));
		Assertions.assertEquals(-1, s.findLUSlength(new String[] { "abe", "abc", "abcde", "abcde" }));
		Assertions.assertEquals(-1, s.findLUSlength(new String[] { "abc", "abc", "abc" }));
		Assertions.assertEquals(3, s.findLUSlength(new String[] { "abc", "cbc", "abd" }));
		Assertions.assertEquals(11, s.findLUSlength(new String[] { "abbaaaaacb", "abaaaaaaaab" }));
	}

//	@Test
	@DisplayName("random")
	public void random() {
		Solution s = new Solution();

		int len = 3;
		String[] strs = new String[len];
		Random r = new Random();
		for (int i = 0; i < len; i++) {
			int slen = r.nextInt(10) + 1;
			slen = 10;
			char[] str = new char[slen];
			for (int j = 0; j < slen; j++) {
				str[j] = (char) (r.nextInt(3) + 97);
			}
			strs[i] = new String(str);
		}

		System.out.println(s.findLUSlength(strs));
	}

}
