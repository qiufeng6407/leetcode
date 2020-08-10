package no_0690_0699;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LC_0696_Base2 {

	class Solution {
	    public int countBinarySubstrings(String s) {
	    	if (s == null || s.isEmpty()) {
	    		return 0;
	    	}
	    	char[] arr = s.toCharArray();
	    	
	    	List<Integer> list = new ArrayList<Integer>();
	    	int pre = 1;
	    	for (int i = 1; i < arr.length; i++) {
    			if (arr[i] != arr[i - 1]) {
    				list.add(pre);
    				pre = 1;
    			} else {
    				pre++;
    			}
    			if (i == arr.length - 1) {
    				list.add(pre);
    			}
	    	}
	    	if (list.size() < 2) {
	    		return 0;
	    	}
	    	int count = 0;
		    for (int i = 1; i < list.size(); i++) {
		    	count += Math.min(list.get(i), list.get(i - 1));
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

}
