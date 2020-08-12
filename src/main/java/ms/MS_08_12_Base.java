package ms;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 面试题 08.12. 八皇后
 * 
 * 
 * @author jlgc
 *
 */
public class MS_08_12_Base {
	
	class Solution {
	    public List<List<String>> solveNQueens(int n) {
	    	List<List<String>> ans = new ArrayList<>();
	    	int[][] used = new int[n][n];
		    solveNQueens(n, used, ans, 0, new int[n]);
	    	return ans;
	    }
	    
	    public void solveNQueens(int n, int[][] used, List<List<String>> ans, int row, int[] res) {
	    	for (int col = 0; col < n; col++) {
	    		if (used[row][col] == 0) {
	    			res[row] = col;
	    			if (row == n - 1) {
	    				add(ans, res);
	    				continue;
	    			}
	    			used[row][col]++;
	    			setValue(n, used, col, row, 1);
	    			solveNQueens(n, used, ans, row + 1, res);
	    			used[row][col]--;
	    			setValue(n, used, col, row, -1);
	    		}
	    	}
	    }
	    
	    private void add(List<List<String>> ans, int[] res) {
	    	List<String> temp = new ArrayList<>();
	    	for (int i = 0; i < res.length; i++) {
	    		StringBuffer sb = new StringBuffer();
	    		for (int j = 0; j < res.length; j++) {
	    			sb.append(j == res[i] ? 'Q' : '.');
	    		}
	    		temp.add(sb.toString());
	    	}
	    	ans.add(temp);
	    }
	    
	    private void setValue(int n, int[][] used, int col, int row, int val) {
			for (int j = 1; row + j < n; j++) {
				used[row + j][col] += val;
			}
			for (int j = 1; row + j < n && col + j < n; j++) {
				used[row + j][col + j] += val;
			}
			for (int j = 1; row + j < n && col - j >= 0; j++) {
				used[row + j][col - j] += val;
			}
	    }
	}
	
	@Test
	@DisplayName("Test 1")
	public void test1() {
		Solution s = new Solution();
		List<List<String>> lists = s.solveNQueens(1);
		for (List<String> list : lists) {
			for (String line : list) {
				System.out.println(line);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 2")
	public void test2() {
		Solution s = new Solution();
		List<List<String>> lists = s.solveNQueens(2);
		for (List<String> list : lists) {
			for (String line : list) {
				System.out.println(line);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 3")
	public void test3() {
		Solution s = new Solution();
		List<List<String>> lists = s.solveNQueens(3);
		for (List<String> list : lists) {
			for (String line : list) {
				System.out.println(line);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 4")
	public void test4() {
		Solution s = new Solution();
		List<List<String>> lists = s.solveNQueens(4);
		for (List<String> list : lists) {
			for (String line : list) {
				System.out.println(line);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	@Test
	@DisplayName("Test 5")
	public void test5() {
		Solution s = new Solution();
		List<List<String>> lists = s.solveNQueens(5);
		for (List<String> list : lists) {
			for (String line : list) {
				System.out.println(line);
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
