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
public class LC_1518_BackTrack {
	class Solution {
		final char[][] btns = new char[][] { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
			
		public List<String> letterCombinations(String digits) {
			List<String> res = new ArrayList<>();
			if (digits == null || digits.isEmpty()) {
				return res;
			}
			char[] digitchar = digits.toCharArray();
			letterCombinations(0, digitchar, new StringBuffer(), res);
			return res;
		}

		public void letterCombinations(int idx, char[] digitchar, StringBuffer curr, List<String> res) {
			int i = Integer.parseInt(String.valueOf(digitchar[idx])) - 2;
			if (idx == digitchar.length - 1) {
				for (int x = 0; x < btns[i].length; x ++) {
					res.add(curr.append(btns[i][x]).toString());
					curr.replace(idx, idx + 1, "");
				}
			} else {
				for (int x = 0; x < btns[i].length; x ++) {
					letterCombinations(idx + 1, digitchar, curr.append(btns[i][x]), res);
					curr.replace(idx, idx + 1, "");
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
