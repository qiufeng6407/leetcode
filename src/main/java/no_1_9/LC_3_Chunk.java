package no_1_9;
public class LC_3_Chunk {
	
    public int lengthOfLongestSubstring(String s) {
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
    	int i = 0, j = 1, max = 1;
		String temp = "";
    	while (i < j && j < s.length()) {
    		temp = s.substring(i, j);
    		char c = s.charAt(j);
    		int idx = temp.indexOf(c);
    		if (idx >= 0) {
				max = Math.max(max, j - i);
    			i += (idx + 1);
    			if (i == j) {
    				j ++;
    			}
    		} else {
    			j ++;
    		}
			if (j == s.length()) {
				max = Math.max(max, j - i);
			}
    	}
    	return max;
    }

	public static void main(String[] args) {
		LC_3_Chunk lc = new LC_3_Chunk();
		
		System.out.println(lc.lengthOfLongestSubstring("abcabcbb")); // 3
		System.out.println(lc.lengthOfLongestSubstring("bbbbb")); // 1
		System.out.println(lc.lengthOfLongestSubstring("pwwkew")); // 3
		System.out.println(lc.lengthOfLongestSubstring("abcdaaaaaaedgtsa")); // 6
		System.out.println(lc.lengthOfLongestSubstring("au")); // 2
		System.out.println(lc.lengthOfLongestSubstring("a")); // 1
		System.out.println(lc.lengthOfLongestSubstring("aab")); // 2
	}

}
