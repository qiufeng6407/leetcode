package no_0660_0669;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LC_0667_Base {

	class Solution {
	    public int[] constructArray(int n, int k) {
	    	int[] ans = new int[n];
	    	int i = 0, s = 1, j = k + 1;
	    	while (i < n) {
	    		if (k >= 0) {
	    			// 偶数位取s,奇数位取j
	    			ans[i] = (i & 1) == 1 ? j-- : s++;
	    			k--;
	    		} else {
	    			ans[i] = i + 1;
	    		}
	    		i++;
	    	}
	    	return ans;
	    }
	}

	@Test
	@DisplayName("test")
	public void test() {
		Solution s = new Solution();

		int[] ans = s.constructArray(3, 1);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(String.format("%d ", ans[i]));
		}
		System.out.println();
	}

	@Test
	@DisplayName("test2")
	public void test2() {
		Solution s = new Solution();

		int[] ans = s.constructArray(3, 2);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(String.format("%d ", ans[i]));
		}
		System.out.println();
	}

	@Test
	@DisplayName("test3")
	public void test3() {
		Solution s = new Solution();

		int[] ans = s.constructArray(4, 1);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(String.format("%d ", ans[i]));
		}
		System.out.println();
	}

	@Test
	@DisplayName("test4")
	public void test4() {
		Solution s = new Solution();

		int[] ans = s.constructArray(4, 2);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(String.format("%d ", ans[i]));
		}
		System.out.println();
	}
	

	@Test
	@DisplayName("test5")
	public void test5() {
		Solution s = new Solution();

		int[] ans = s.constructArray(10, 3);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(String.format("%d ", ans[i]));
		}
		System.out.println();
	}
	
	@Test
	@DisplayName("test6")
	public void test6() {
		Solution s = new Solution();

		int[] ans = s.constructArray(10, 9);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(String.format("%d ", ans[i]));
		}
		System.out.println();
	}

}
