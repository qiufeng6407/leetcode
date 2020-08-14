package no_0020_0029;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author jlgc
 *
 */
public class LC_20_Base {
	
	class Solution {
	    public boolean isValid(String s) {
	    	if ((s.length() & 1) == 1) { //  加速判断：根据题解来的
	    		return false;
	    	}
	    	Stack<Character> stack = new Stack<Character>();
	    	Map<Character, Character> pairs = new HashMap<Character, Character>() {{
	            put(')', '(');
	            put(']', '[');
	            put('}', '{');
	        }};

	    	for (int i = 0; i < s.length(); i++) {
	    		char c = s.charAt(i);
	    		if (pairs.containsKey(c)) {
	    			if (!stack.isEmpty() && stack.pop() != pairs.get(c)) {
	        			return false;
	        		}
	    		} else {
            		stack.push(c);
	    		}
	    	}
	    	return stack.isEmpty();
	    }
	}

	@Test
	@DisplayName("3")
	public void test1() {
		Solution s = new Solution();
		Assertions.assertTrue(s.isValid(""));
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
