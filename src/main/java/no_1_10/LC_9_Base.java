package no_1_10;

public class LC_9_Base {

    public boolean isPalindrome(int x) {
    	if (x < 0) return false;
    	char[] ca = String.valueOf(x).toCharArray();
    	for (int i = 0, j = ca.length - 1; i <= j; i++, j--) {
    		if (ca[i] != ca[j]) {
    			return false;
    		}
    	}
    	return true;
    }

	public static void main(String[] args) {
		LC_9_Base lc = new LC_9_Base();

		assert lc.isPalindrome(-123) == false : "";
		assert lc.isPalindrome(-121) == false : "";
		assert lc.isPalindrome(121) == true : "";
		assert lc.isPalindrome(0) == true : "";
		assert lc.isPalindrome(12) == false : "";
		assert lc.isPalindrome(11) == true : "";
		
	}

}
