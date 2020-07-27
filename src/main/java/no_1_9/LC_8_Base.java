package no_1_9;

public class LC_8_Base {

    public int myAtoi(String str) {
    	if (str == null || str.length() == 0) {
    		return 0;
    	}
    	char[] cs = str.toCharArray();
    	
    	int rs = 0, fg = 1;
    	boolean hasValue = false;
    	int max10 = Integer.MAX_VALUE / 10;
    	int min10 = Integer.MIN_VALUE / 10;
    	for (int i = 0; i < cs.length; i++) {
    		if (cs[i] >= '0' && cs[i] <= '9') {
    			if (!hasValue) hasValue = true;
    			int pop = ((int) cs[i]) - 48;
    			if (fg > 0 && (rs > max10 || (rs == max10 && pop > 7))) return Integer.MAX_VALUE;
    			if (fg < 0 && (-rs < min10 || (-rs == min10 && -pop < -8))) return Integer.MIN_VALUE;
    			
    			System.out.println( fg + "        " + rs + "    " + pop);
    			rs = rs * 10 + pop;
    		} else if (cs[i] == '-' || cs[i] == '+') {
    			if (hasValue) return rs * fg;
    			hasValue = true;
    			fg = cs[i] == '-' ? -1 : 1;
    		} else if (cs[i] == ' ') {
    			if (!hasValue) continue;
    			return rs * fg;
    		} else {
    			return rs * fg;
    		}
    	}
		return rs * fg;
    }

	public static void main(String[] args) {
		LC_8_Base lc = new LC_8_Base();

		System.out.println(lc.myAtoi("-5-")); // -5
		System.out.println(lc.myAtoi("-2147483649")); // -2147483648
		System.out.println(lc.myAtoi("-91283472332")); // -2147483648
		System.out.println(lc.myAtoi("-3.14159")); // -3
		System.out.println(lc.myAtoi("3.14159")); // 3
		System.out.println(lc.myAtoi(null)); // 0
		System.out.println(lc.myAtoi("")); // 0
		System.out.println(lc.myAtoi("  ")); // 0
		System.out.println(lc.myAtoi("42")); // 42
		System.out.println(lc.myAtoi("-42")); // -42
		System.out.println(lc.myAtoi("  -42")); // -42
		System.out.println(lc.myAtoi("   42")); // 42
		System.out.println(lc.myAtoi("   a42")); // 0
		System.out.println(lc.myAtoi("   -a42")); // 0
		System.out.println(lc.myAtoi("   -4a2")); // -4
		System.out.println(lc.myAtoi("  -4 d")); // -4
		System.out.println(lc.myAtoi("  -4 3")); // -4
	}

}
