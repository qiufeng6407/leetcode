package no_0001_0009;
public class LC_5_Dp {

	public String longestPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		
		int length = s.length();
		char[] sc = s.toCharArray();
		boolean[][] dp = new boolean[length][length];
		int start = 0, max = 1;

		for (int i = 1; i < length; i++) {
			dp[i][i] = true;
		}
		for (int j = 1; j < length; j++) {
			for (int i = 0; i < j; i ++) {
				if (j - i > 2) {
					dp[i][j] = dp[i + 1][j - 1] && sc[i] == sc[j];
				} else {
					dp[i][j] = sc[i] == sc[j];
				}
				if (dp[i][j] && j - i + 1 > max) {
					max = j - i + 1;
					start = i;
				}
			}
		}
		return s.substring(start, start + max);
    }

	public static void main(String[] args) {
		LC_5_Dp lc = new LC_5_Dp();
		
		System.out.println(lc.longestPalindrome("abcabcbb")); // bcb
		System.out.println(lc.longestPalindrome("bbbbb")); // bbbbb
		System.out.println(lc.longestPalindrome("pwwkew")); // ww
		System.out.println(lc.longestPalindrome("abcdaaaaaaedgtsa")); // aaaaaa
		System.out.println(lc.longestPalindrome("au")); // a
		System.out.println(lc.longestPalindrome("a")); // a
		System.out.println(lc.longestPalindrome("aab")); // aa
		System.out.println(lc.longestPalindrome("babad")); // aba
		System.out.println(lc.longestPalindrome("cbbd")); // bb
	}

}
