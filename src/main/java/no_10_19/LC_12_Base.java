package no_10_19;

public class LC_12_Base {

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
    	int[] divisors = { 1, 5, 10, 50, 100, 500, 1000 };
    	char[] roman = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
    	String s = "";
    	for (int i = 0; i < divisors.length; i+=2) {
    		int quo = num % 10;
    		if (quo < 4) {
        		for (int j = 0; j < quo; j++) {
        			s = roman[i] + s;
        		}
    		} else if (quo == 4) {
    			s = roman[i] + "" + roman[i + 1] + s;
    		} else if (quo == 5) {
    			s = roman[i + 1] + s;
    		} else if (quo > 5 && quo < 9) {
        		for (int j = 0; j < quo - 5; j++) {
        			s = roman[i] + s;
        		}
    			s = roman[i + 1] + s;
    		} else if (quo == 9) {
    			s = roman[i] + "" + roman[i + 2] + s;
    		} else {
    			break;
    		}
    		num = num / 10;
    	}
    	return s;
    }

	public static void main(String[] args) {
		LC_12_Base lc = new LC_12_Base();

		for (int i = 1 ; i < 2000; i++) {
			System.out.print(String.format("%4d: %s \t" , i, lc.intToRoman(i)));
			if (i % 10 == 0) {
				System.out.println();
			}
		}

	}

}
