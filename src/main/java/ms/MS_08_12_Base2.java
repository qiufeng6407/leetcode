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
public class MS_08_12_Base2 {
	
	class Solution {
	    public List<List<String>> solveNQueens(int n) {
	    	List<List<String>> ans = new ArrayList<>();
	    	int[][] used = new int[n][n];
	    	char[][] res = new char[n][n];
	    	for (int i = 0; i < n; i++) {
	    		for (int j = 0; j < n; j++) {
	    			res[i][j] = '.';
	    		}
	    	}
		    solveNQueens(n, used, ans, 0, res);
	    	return ans;
	    }
	    
	    public void solveNQueens(int n, int[][] used, List<List<String>> ans, int row, char[][] res) {
	    	for (int col = 0; col < n; col++) {
	    		if (used[row][col] == 0) {
	    			res[row][col] = 'Q';
	    			if (row == n - 1) {
		    			List<String> temp = new ArrayList<>();
		    			for (char[] re : res) {
		    				temp.add(new String(re));
		    			}
		    			ans.add(temp);
		    			res[row][col] = '.';
	    				continue;
	    			}
	    			addValue(n, used, col, row, 1);
	    			solveNQueens(n, used, ans, row + 1, res);
	    			addValue(n, used, col, row, -1);
	    			res[row][col] = '.';
	    		}
	    	}
	    }
	    
	    private void addValue(int n, int[][] used, int col, int row, int val) {
	    	used[row][col] += val;
			for (int j = 1; row + j < n; j++) {
				used[row + j][col] += val;
				if (col + j < n) used[row + j][col + j] += val;
				if (col - j >= 0) used[row + j][col - j] += val;
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
