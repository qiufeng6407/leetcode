package no_1_10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LC_8_Pattern {

    public int myAtoi(String str) {
    	if (str == null || str.length() == 0) return 0;
    	Pattern p = Pattern.compile("^\\s*((\\-|\\+)?\\d+).*$");
    	Matcher m = p.matcher(str);
    	if (!m.find()) return 0;
    	String s = m.group(1);
    	long l = 0;
    	try {
        	l = Long.parseLong(s);
    	} catch (NumberFormatException e) {
			if (s.indexOf("-") > -1) return Integer.MIN_VALUE;
			return Integer.MAX_VALUE;
		}
    	if (l > Integer.MAX_VALUE) return Integer.MAX_VALUE;
    	if (l < Integer.MIN_VALUE) return Integer.MIN_VALUE;
    	return (int) l;
    }

	public static void main(String[] args) {
		LC_8_Pattern lc = new LC_8_Pattern();

		System.out.println(lc.myAtoi("20000000000000000000")); // -2147483647
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
