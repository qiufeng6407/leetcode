package no_1_9;

public class LC_7_Base4 {

    public int reverse(int x) {
    	if (x > -9 && x < 9) return x;
    	final int max = 0x7fffffff, min = 0x80000000;
    	final int max10 = max / 10;
    	final int min10 = min / 10;
    	int r = 0;
    	while (x != 0) {
    		int pop = x % 10;
    		if (r > max10 || (r == max10 && pop > 7)) return 0;
    		if (r < min10 || (r == min10 && pop < -8)) return 0;
    		r = r * 10 + pop;
    		x /= 10;
    	}
    	return r;
    }

	public static void main(String[] args) {
		LC_7_Base4 lc = new LC_7_Base4();
		
		System.out.println(lc.reverse(+321)); // 123
		System.out.println(lc.reverse(321)); // 123
		System.out.println(lc.reverse(-321)); // -123
		System.out.println(lc.reverse(-2147483648)); // 0
		System.out.println(lc.reverse(2147483647)); // 0
		System.out.println(lc.reverse(+2147483647)); // 0
	}

}
