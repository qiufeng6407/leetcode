package no_0010_0019;

public class LC_12_Base2 {

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
    public String intToRoman(int num) {
    	int[] divisors = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
    	String[] roman = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
    	StringBuffer sb = new StringBuffer();
    	while (num > 0) {
    		for (int i = divisors.length - 1; i >= 0; i--) {
    			while (num > 0 && num >= divisors[i]) {
    				sb.append(roman[i]);
    				num -= divisors[i];
    			}
    		}
    	}
    	return sb.toString();
    }

	public static void main(String[] args) {
		LC_12_Base2 lc = new LC_12_Base2();

		for (int i = 1 ; i < 2000; i++) {
			System.out.print(String.format("%4d: %s \t" , i, lc.intToRoman(i)));
			if (i % 10 == 0) {
				System.out.println();
			}
		}

	}

}
