package no_1_10;

public class LC_7_Base3 {

    public int reverse(int x) {
    	if (x > -9 && x < 9) return x;
    	int r = 0;
    	while (x != 0) {
    		int pop = x % 10;
    		if (r > Integer.MAX_VALUE / 10 || (r == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
    		if (r < Integer.MIN_VALUE / 10 || (r == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
    		r = r * 10 + pop;
    		x /= 10;
    	}
    	return r;
    }

	public static void main(String[] args) {
		LC_7_Base3 lc = new LC_7_Base3();

		System.out.println(lc.reverse(+321)); // 123
		System.out.println(lc.reverse(321)); // 123
		System.out.println(lc.reverse(-321)); // -123
		System.out.println(lc.reverse(-2147483648)); // 0
		System.out.println(lc.reverse(2147483647)); // 0
		System.out.println(lc.reverse(+2147483647)); // 0
	}

}
