package no_1510_1519;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 17. 电话号码的字母组合
 * 
 * @author jlgc
 *
 */
public class LC_1518_BackTrack2 {
	class Solution {
		final char[][] btns = new char[][] { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
			
		public List<String> letterCombinations(String digits) {
			List<String> res = new ArrayList<>();
			if (digits == null || digits.isEmpty()) {
				return res;
			}
			letterCombinations(0, digits.toCharArray(), new char[digits.length()], res);
			return res;
		}

		public void letterCombinations(int idx, char[] digitchar, char[] target, List<String> res) {
			int i = Integer.parseInt(String.valueOf(digitchar[idx])) - 2;
			for (int x = 0; x < btns[i].length; x ++) {
				target[idx] = btns[i][x];
				if (idx == digitchar.length - 1) {
					res.add(new String(target));
				} else {
					letterCombinations(idx + 1, digitchar, target, res);
				}
			}
		}
	}

	@Test
	public void test() {
		Solution s = new Solution();

		System.out.println(s.letterCombinations(null));
		System.out.println(s.letterCombinations(""));
		System.out.println(s.letterCombinations("2"));
		System.out.println(s.letterCombinations("23"));
		System.out.println(s.letterCombinations("223"));
	}

}
