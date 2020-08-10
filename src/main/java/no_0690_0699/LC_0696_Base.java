package no_0690_0699;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LC_0696_Base {

	class Solution {
	    public int countBinarySubstrings(String s) {
	    	if (s == null || s.isEmpty()) {
	    		return 0;
	    	}
	    	char[] arr = s.toCharArray();
	    	
	    	int count = 0, pre = 0;
	    	char flag = '0';
	    	for (int i = 0; i < arr.length; i++) {
    			if (pre == 0) {
    				flag = arr[i];
    				pre ++;
    				continue;
    			}
	    		if (arr[i] == flag) {
	    			pre ++;
	    			continue;
	    		}
	    		int j = i;
	    		while (pre > 0 && j < arr.length && arr[j] != flag) {
	    			count++;
	    			pre--;
	    			j++;
	    		}
	    		pre = 1;
	    		flag = arr[i];
	    	}
	    	return count;
	    }
	}

	@Test
	@DisplayName("test")
	public void test() {
		Solution s = new Solution();
		Assertions.assertEquals(6, s.countBinarySubstrings("00110011"));
		Assertions.assertEquals(4, s.countBinarySubstrings("10101"));
		Assertions.assertEquals(1, s.countBinarySubstrings("10"));
		Assertions.assertEquals(1, s.countBinarySubstrings("01"));
		Assertions.assertEquals(2, s.countBinarySubstrings("010"));
		Assertions.assertEquals(0, s.countBinarySubstrings("0"));
		Assertions.assertEquals(0, s.countBinarySubstrings("1"));
		Assertions.assertEquals(0, s.countBinarySubstrings(""));
	}

	@Test
	@DisplayName("test2")
	public void test2() {
		Solution s = new Solution();
		Random r = new Random();
		for (int x = 0; x <10; x++) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 10; i++) {
				sb.append(r.nextInt(2));
			}
			System.out.println(String.format("%d, %s", s.countBinarySubstrings(sb.toString()), sb.toString()));
		}
	}

}
