package no_0001_0009;
public class LC_5_Base {

	public String longestPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i ++) {
			int x = i, y = i + 1;
			while (x >= 0 && y < s.length() && s.charAt(x) == s.charAt(y)) {
				x --;
				y ++;
			}
			if (y - x> end -start) {
				start = x; end = y;
			}
			
			x = i - 1; y = i + 1;
			while (x >= 0 && y < s.length() && s.charAt(x) == s.charAt(y)) {
				x --;
				y ++;
			}
			if (y - x > end -start) {
				start = x; end = y;
			}
		}
		
		return s.substring(start + 1, end);
    }

	public static void main(String[] args) {
		LC_5_Base lc = new LC_5_Base();
		
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
