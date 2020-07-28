package no_0390_0399;

public class LC_392_Base {

    public boolean isSubsequence(String s, String t) {
    	if (s == null || t == null || s.length() > t.length()) return false;
    	if (s.isEmpty()) return true;
    	int i = 0, j = 0;
    	while (i < s.length() && j < t.length()) {
    		if (s.charAt(i) == t.charAt(j)) i++;
    		j++;
    	}
    	return i == s.length();
    }

	public static void main(String[] args) {
		LC_392_Base lc = new LC_392_Base();
		System.out.println("==============" + lc.isSubsequence("abc", "ahbgdc"));
	}

}
