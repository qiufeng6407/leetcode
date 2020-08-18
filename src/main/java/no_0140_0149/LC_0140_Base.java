package no_0140_0149;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author jlgc
 *
 */
public class LC_0140_Base {

	class Solution {
	    public List<String> wordBreak(String s, List<String> wordDict) {
			List<String> ans = new ArrayList<>();
	    	if (s.length() == 0) {
	    		return ans;
	    	}
			Collections.sort(wordDict, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.length() - o2.length();
				}
			});
	    	int[] dp = new int[s.length()];
	    	Arrays.fill(dp, -1);
	    	wordBreak(s, 0, ans, dp, new ArrayList<>(), wordDict);
	    	return ans;
	    }
	    
	    public void wordBreak(String s, int index, List<String> ans, int[] dp, List<String> curr, List<String> wordDict) {
	    	if (dp[index] == -1) {
	    		dp[index] = 0;
	    	} else if (dp[index] == 0) {
	    		return;
	    	}
	    	for (int i = 0; i < wordDict.size(); i++) {
	    		String word = wordDict.get(i);
//	    		System.out.println(String.format("check from %d withword [%s] in [%s]", index, word, new String(s, index, s.length - index)));
	    		if (index + word.length() > s.length()) {
	    			return;
	    		}
	    		String sub = s.substring(index, index + word.length());
	    		if (sub.equals(word)) {
		    		dp[index] ++;
	    			curr.add(sub);
	    			if (index + word.length() == s.length()) {
	    				ans.add(String.join(" ", curr));
	    			} else {
		    			wordBreak(s, index + word.length(), ans, dp, curr, wordDict);
		    			if (dp[index + word.length()] == 0) {
				    		dp[index] --;
		    			}
//			    		System.out.println(String.format("dp[%d]=%d", index, dp[index]));
	    			}
	    			curr.remove(curr.size() - 1); // 回溯
	    		}
	    	}
	    }
	}
	
	@Test
	@DisplayName("0")
	public void test0() {
		Solution s = new Solution();
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		System.out.println(s.wordBreak("", wordDict));
	}

	@Test
	@DisplayName("1")
	public void test1() {
		Solution s = new Solution();
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		System.out.println(s.wordBreak("catsanddog", wordDict));
	}

	@Test
	@DisplayName("2")
	public void test2() {
		Solution s = new Solution();
		List<String> wordDict = new ArrayList<>();
		wordDict.add("apple");
		wordDict.add("pen");
		wordDict.add("applepen");
		wordDict.add("pine");
		wordDict.add("pineapple");
		System.out.println(s.wordBreak("pineapplepenapple", wordDict));
	}

	@Test
	@DisplayName("3")
	public void test3() {
		Solution s = new Solution();
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		System.out.println(s.wordBreak("catsandog", wordDict));
	}
	@Test
	@DisplayName("4")
	public void test4() {
		Solution s = new Solution();
		List<String> wordDict = new ArrayList<>();
		wordDict.add("ca");
		wordDict.add("ac");
		wordDict.add("aca");
		wordDict.add("cac");
		wordDict.add("a");
		wordDict.add("c");
		System.out.println(s.wordBreak("cacaca", wordDict));
	}
	
	@Test
	@DisplayName("5")
	public void test5() {
		Solution s = new Solution();
		List<String> wordDict = new ArrayList<>();
		wordDict.add("a");
		wordDict.add("aa");
		wordDict.add("aaa");
		wordDict.add("aaaa");
		wordDict.add("aaaaa");
		wordDict.add("aaaaaa");
		wordDict.add("aaaaaaa");
		wordDict.add("aaaaaaaa");
		wordDict.add("aaaaaaaaa");
		wordDict.add("aaaaaaaaaa");
		System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", wordDict));
	}
	
	@Test
	@DisplayName("6")
	public void test6() {
		Solution s = new Solution();
		List<String> wordDict = new ArrayList<>();
		wordDict.add("aaaa");
		wordDict.add("aaa");
		System.out.println(s.wordBreak("aaaaaaa", wordDict));
	}

}
