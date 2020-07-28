package no_0001_0009;

public class LC_9_Base2 {

    public boolean isPalindrome(int x) {
    	if (x < 0 || (x != 0 && x % 10 == 0)) return false;
    	if (x < 10) return true;
    	int r = 0, t = x;
    	while (t > 0) {
    		r = r * 10 + t % 10;
    		t = t / 10;
    	}
    	return r == x;
    }

	public static void main(String[] args) {
		LC_9_Base2 lc = new LC_9_Base2();

		assert lc.isPalindrome(-123) == false : "";
		assert lc.isPalindrome(-121) == false : "";
		assert lc.isPalindrome(121) == true : "";
		assert lc.isPalindrome(0) == true : "";
		assert lc.isPalindrome(12) == false : "";
		assert lc.isPalindrome(11) == true : "";
		
	}

}
