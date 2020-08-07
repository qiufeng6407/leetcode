

package no_0330_0339;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 336. 回文对
 * 
 * 输入: ["abcd","dcba","lls","s","sssll"]
输出: [[0,1],[1,0],[3,2],[2,4]] 
解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 *
 */
public class LC_337_Base {
	class Solution {
	    public List<List<Integer>> palindromePairs(String[] words) {
	    	List<List<Integer>> res = new ArrayList<>();
	    	for (int i = 0; i < words.length; i++) {
	    		for (int j = 0; j < words.length; j++) {
	    			if (i == j) continue;
	    			if (isHW(words[i], words[j])) {
		    			List<Integer> rec = new ArrayList<>();
	    				rec.add(i);
	    				rec.add(j);
	    				res.add(rec);
	    			}
	    			
	    		}
	    	}
	    	return res;
	    }
	    
	    private boolean isHW(String s1, String s2) {
	    	int i = 0, j = s2.length() - 1;
	    	while (i < s1.length() && j >= 0) {
	    		if (s1.charAt(i) != s2.charAt(j)) return false;
	    		i++; j--;
	    	}
	    	if (i == s1.length() && j == 0) return true;
	    	
	    	String temp;
	    	if (i >= s1.length() && j >= 0) { // s1结束
	    		temp = s2.substring(0, j + 1);
	    	} else {
	    		temp = s1.substring(i, s1.length());
	    	}
    		i = 0; j = temp.length() - 1;
    		while (i < j) {
	    		if (temp.charAt(i) != temp.charAt(j)) return false;
	    		i++; j--;
    		}
    		return true;
	    }
	    
	}

	@Test
	@DisplayName("3")
	public void test1() {
		Solution s = new Solution();
		System.out.println(s.palindromePairs(new String[] { "abcd","dcba","lls","s","sssll" } ));
		System.out.println(s.palindromePairs(new String[] { "bat","tab","cat" } ));
	}


}
