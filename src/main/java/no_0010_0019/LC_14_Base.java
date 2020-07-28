package no_0010_0019;

/**
 * 14. 最长公共前缀
 * @author jlgc
 *
 */
public class LC_14_Base {

    public String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length == 0) return "";
    	if (strs.length == 1) return strs[0];
    	int minLen = Integer.MAX_VALUE;
    	for (String str : strs) {
    		if (str.length() == 0) return "";
    		minLen = Math.min(str.length(), minLen);
    	}
    	int end = -1;
    	for (int i = 0; i < minLen; i++, end = i) {
    		boolean eq = true;
    		for (int j = 1; j < strs.length; j++) {
    			if (strs[j].charAt(i) != strs[0].charAt(i)) {
    				eq = false;
    				break;
    			}
    		}
    		if (!eq) break;
    	}
    	if (end < 0) return "";
    	return strs[0].substring(0, end);
    }

	public static void main(String[] args) {
		LC_14_Base lc = new LC_14_Base();

		System.out.println(lc.longestCommonPrefix(new String[] { "flower" }));
		System.out.println(lc.longestCommonPrefix(null));
		System.out.println(lc.longestCommonPrefix(new String[] { "flower","","flight" }));
		System.out.println(lc.longestCommonPrefix(new String[] { "flower","flow","flight" }));
		System.out.println(lc.longestCommonPrefix(new String[] { "dog","racecar","car" }));

	}

}
