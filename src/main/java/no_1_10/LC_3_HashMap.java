package no_1_10;

import java.util.HashMap;
import java.util.Map;

public class LC_3_HashMap {
	
    public int lengthOfLongestSubstring(String s) {
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
    	int max = 0;
		for (int i = 0; i < s.length(); i++) {
	    	Map<Character, Integer> m = new HashMap<>();
	    	m.put(s.charAt(i), i);
			int j = i + 1;
			while (j < s.length()) {
				if (m.containsKey(s.charAt(j))) {
					max = Math.max(max, j - i);
					i = m.get(s.charAt(j));
					break;
				}
				m.put(s.charAt(j), j);
				j++;
			}
			max = Math.max(max, j - i);
		}
    	return max;
    }

	public static void main(String[] args) {
		LC_3_HashMap lc = new LC_3_HashMap();

		System.out.println(lc.lengthOfLongestSubstring("dvdf")); // 3
//		System.out.println(lc.lengthOfLongestSubstring("abcabcbb")); // 3
//		System.out.println(lc.lengthOfLongestSubstring("bbbbb")); // 1
//		System.out.println(lc.lengthOfLongestSubstring("pwwkew")); // 3
//		System.out.println(lc.lengthOfLongestSubstring("abcdaaaaaaedgtsa")); // 6
//		System.out.println(lc.lengthOfLongestSubstring("au")); // 2
//		System.out.println(lc.lengthOfLongestSubstring("a")); // 1
//		System.out.println(lc.lengthOfLongestSubstring("aab")); // 2
	}

}
