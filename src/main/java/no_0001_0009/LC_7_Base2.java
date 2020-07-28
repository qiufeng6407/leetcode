package no_0001_0009;
public class LC_7_Base2 {

    public int reverse(int x) {
    	if (x > -9 && x < 9) return x;
    	long xl = Math.abs(x);
    	long rl = 0;
    	while (xl > 0) {
    		rl = rl * 10 + xl % 10;
    		xl /= 10;
    	}
    	if (x < 0) rl = -rl;
    	return rl < Integer.MIN_VALUE || rl > Integer.MAX_VALUE ? 0 : (int) rl;
    }

	public static void main(String[] args) {
		LC_7_Base2 lc = new LC_7_Base2();
		
		System.out.println(-123 / 10);

		System.out.println(lc.reverse(+321)); // 123
		System.out.println(lc.reverse(321)); // 123
		System.out.println(lc.reverse(-321)); // -123
		System.out.println(lc.reverse(-2147483648)); // 0
		System.out.println(lc.reverse(2147483647)); // 0
		System.out.println(lc.reverse(+2147483647)); // 0
	}

}
