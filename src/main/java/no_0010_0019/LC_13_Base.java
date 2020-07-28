package no_0010_0019;

import java.util.HashMap;
import java.util.Map;

public class LC_13_Base {

	/**
	 * 字符                         数值
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
	 * @param num
	 * @return
	 */
	 public int romanToInt(String s) {
    	Map<String, Integer> mp = new HashMap<>();
    	mp.put("M", 1000);
    	mp.put("CM", 900);
    	mp.put("D", 500);
    	mp.put("CD", 400);
    	mp.put("C", 100);
    	mp.put("XC", 90);
    	mp.put("L", 50);
    	mp.put("XL", 40);
    	mp.put("X", 10);
    	mp.put("IX", 9);
    	mp.put("V", 5);
    	mp.put("IV", 4);
    	mp.put("I", 1);
    	char[] sc = s.toCharArray();
    	int num = 0;
		String x = "";
    	for (int i = 0; i < sc.length; i++) {
			x += sc[i];
    		if (!mp.containsKey(x) || (i < sc.length - 1 && mp.containsKey(x + sc[i + 1]))) {
    			continue;
    		}
    		num += mp.get(x);
    		x = "";
    	}
    	return num;
    }

	public static void main(String[] args) {
		LC_12_Base lc12 = new LC_12_Base();
		LC_13_Base lc = new LC_13_Base();

		for (int i = 1; i < 3999; i++) {
			if (lc.romanToInt(lc12.intToRoman(i)) != i) {
				System.out.println(lc12.intToRoman(i));
				break;
			}
		}

	}

}
