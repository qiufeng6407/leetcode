package ms;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
回文串不一定是字典当中的单词。

示例1：
输入："tactcoa"
输出：true（排列有"tacocat"、"atcocta"，等等）
 * 
 * @author jlgc
 *
 */
public class MS_01_04_Base {

	class Solution {
	    public boolean canPermutePalindrome(String s) {
	    	Map<Character, Integer> charMap = new HashMap<>();
	    	for (int i = 0; i < s.length(); i++) {
	    		char c = s.charAt(i);
	    		if (!charMap.containsKey(c)) {
	    			charMap.put(c, 1);
	    		} else {
	    			charMap.put(c, charMap.get(c) + 1);
	    		}
	    	}
	    	int[] evenodd = new int[2];
	    	charMap.values().forEach((i)-> {
	    		evenodd[i & 1]++;
	    	});
	    	if ((s.length() & 1) == 0) {
	    		return evenodd[1] == 0;
	    	} else {
	    		return evenodd[1] == 1;
	    	}
	    }
	}

	@Test
	public void test() {
		Solution s = new Solution();
		Assertions.assertTrue(s.canPermutePalindrome(""));
		Assertions.assertTrue(s.canPermutePalindrome("a"));
		Assertions.assertTrue(s.canPermutePalindrome("tactcoa"));
		Assertions.assertTrue(s.canPermutePalindrome("tactcaa"));
		Assertions.assertFalse(s.canPermutePalindrome("tactcoaa"));
	}

}
