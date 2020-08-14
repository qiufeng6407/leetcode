package no_0020_0029;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author jlgc
 *
 */
public class LC_20_Base2 {
	
	class Solution {
	    public boolean isValid(String s) {
	    	if ((s.length() & 1) == 1) { //  加速判断：根据题解来的
	    		return false;
	    	}
	    	char[] stack = new char[s.length()];
	    	int index = 0;
	    	for (int i = 0; i < s.length(); i++) {
	    		char c = s.charAt(i);
	    		switch (c) {
				case '}':
					if (index == 0 || stack[--index] != '{') return false;
					break;
				case ']':
					if (index == 0 || stack[--index] != '[') return false;
					break;
				case ')':
					if (index == 0 || stack[--index] != '(') return false;
					break;
				default:
					stack[index++] = c;
					break;
				}
	    	}
	    	return index == 0;
	    }
	}

	@Test
	@DisplayName("3")
	public void test1() {
		Solution s = new Solution();
		Assertions.assertTrue(s.isValid(""));
		Assertions.assertFalse(s.isValid("){"));
		Assertions.assertFalse(s.isValid("([)]"));
		Assertions.assertTrue(s.isValid("()"));
		Assertions.assertTrue(s.isValid("()[]{}"));
		Assertions.assertFalse(s.isValid("(]"));
		Assertions.assertTrue(s.isValid("{[]}"));
		Assertions.assertTrue(s.isValid("{[{}]}"));
		Assertions.assertTrue(s.isValid("{[{}]}{}"));
		Assertions.assertTrue(s.isValid("{[{}]}[{}]"));
		Assertions.assertTrue(s.isValid("[{[{}]}[{}]]"));
	}

}
