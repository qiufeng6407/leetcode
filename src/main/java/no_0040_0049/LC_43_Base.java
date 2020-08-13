package no_0040_0049;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author jlgc
 *
 */
public class LC_43_Base {

	class Solution {
		public String multiply(String num1, String num2) {
			if ("0".equals(num1) || "0".equals(num2)) {
				return "0";
			}
			int[] ans = new int[num1.length() + num2.length()];
			
			if (num1.length() > num2.length()) {
				String temp = num1;
				num1 = num2;
				num2 = temp;
			}
			int[][] dp = new int[10][num1.length() + 1];
			boolean[] flag = new boolean[10];
			int[] num = new int[num1.length()];
			for (int i = 0; i < num1.length(); i++) {
				num[i] = num1.charAt(i) - 48;
			}
			for (int i = num2.length() - 1; i >= 0; i--) {
				multiply(ans, dp, flag, num, num2.charAt(i) - 48, num2.length() - i - 1);
			}
			int i = 0;
			while (ans[i] == 0) i++;
			StringBuffer sb = new StringBuffer();
			for (; i < ans.length; i++) {
				sb.append(ans[i]);
			}
			return sb.toString();
		}
		
		/**
		 * 
		 * @param ans
		 * @param num
		 * @param b [0-9]
		 * @param offset
		 * @return
		 */
		public void multiply(int[] ans, int[][] dp, boolean[] flag, int[] num, int b, int offset) {
			if (b == 0) return;
			int[] res = dp[b];
			if (!flag[b]) {
				int carry = 0, i = num.length - 1, j = res.length - 1;
				for (; i >= 0; i--, j--) {
					int val = num[i] * b + carry;
					res[j] = val % 10;
					carry = val / 10;
				}
				if (carry > 0) {
					res[j] = carry;
				}
				flag[b] = true;
				dp[b] = res;
			}
			
			int carry = 0, i = res.length - 1, j = ans.length - offset - 1;
			for (; j >= 0 && i >= 0; i--, j--) {
				int val = ans[j] + res[i] + carry;
				ans[j] = val % 10;
				carry = val / 10;
			}
			while (carry > 0) {
				int val = ans[j] + carry;
				ans[j] = val % 10;
				carry = val / 10;
				j--;
			}
		}
	}

	@Test
	@DisplayName("3")
	public void test1() {
		Solution s = new Solution();
		Assertions.assertEquals("14543245767711675797514270089712325130928", s.multiply("331747498237328238", "43838298238823822929256"));
		Assertions.assertEquals("56088", s.multiply("123", "456"));
		Assertions.assertEquals("6", s.multiply("2", "3"));
		Assertions.assertEquals("0", s.multiply("2", "0"));
	}

}
