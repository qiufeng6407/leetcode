package no_1_10;
public class LC_7_Base {

    public int reverse(int x) {
    	String s = String.valueOf(x);
    	if (x < 0) s = s.substring(1);
    	String r = x < 0 ? "-" : "";
    	for (int i = s.length() - 1; i >= 0; i--) r += s.charAt(i);
    	long rl = Long.parseLong(r.toString());
    	return rl < Integer.MIN_VALUE || rl > Integer.MAX_VALUE ? 0 : (int) rl;
    }

	public static void main(String[] args) {
		LC_7_Base lc = new LC_7_Base();

		System.out.println(lc.reverse(+321)); // 123
		System.out.println(lc.reverse(321)); // 123
		System.out.println(lc.reverse(-321)); // -123
		System.out.println(lc.reverse(-2147483648)); // 0
		System.out.println(lc.reverse(2147483647)); // 0
		System.out.println(lc.reverse(+2147483647)); // 0
	}

}
