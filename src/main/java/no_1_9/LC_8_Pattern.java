package no_1_9;

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

		assert lc.myAtoi("-5-") == -5 : "";
		assert lc.myAtoi("20000000000000000000") == 2147483647 : "";
		assert lc.myAtoi("-2147483649") == -2147483648 : "";
		assert lc.myAtoi("-91283472332") == -2147483648 : "";
		assert lc.myAtoi("-3.14159") == -3 : "";
		assert lc.myAtoi("3.14159") == 3 : "";
		assert lc.myAtoi(null) == 0 : "";
		assert lc.myAtoi("") == 0 : "";
		assert lc.myAtoi("   ") == 0 : "";
		assert lc.myAtoi("-42") == -42 : "";
		assert lc.myAtoi("42") == 42 : "";
		assert lc.myAtoi("   -42") == -42 : "";
		assert lc.myAtoi("   42") == 42 : "";
		assert lc.myAtoi("   -a42") == 0 : "";
		assert lc.myAtoi("   42") == 42 : "";
		assert lc.myAtoi("   -4a2") == -4 : "";
		assert lc.myAtoi("   4a2") == 4 : "";
		assert lc.myAtoi("   -42 d") == -42 : "";
		assert lc.myAtoi("   42 3") == 42 : "";
		
	}

}
