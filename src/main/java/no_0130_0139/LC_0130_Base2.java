package no_0130_0139;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LC_0130_Base2 {

	class Solution {
		public void solve(char[][] board) {
			if (board.length < 3 || board[0].length < 3) {
				return;
			}
			int m = board.length, n = board[0].length;
			for (int i = 0; i < m; i++) {
				dfs(board, i, 0, m, n);
				dfs(board, i, n - 1, m, n);
			}
			for (int i = 0; i < n; i++) {
				dfs(board, 0, i, m, n);
				dfs(board, m - 1, i, m, n);
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 'X') {
						continue;
					}
					board[i][j] = board[i][j] == '*' ? 'O' : 'X';
				}
			}
		}

		public void dfs(char[][] board, int i, int j, int m, int n) {
			if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O' || board[i][j] == '*') {
				return;
			}
			board[i][j] = '*';
			dfs(board, i - 1, j, m, n);
			dfs(board, i + 1, j, m, n);
			dfs(board, i, j - 1, m, n);
			dfs(board, i, j + 1, m, n);
		}
	}

	@Test
	@DisplayName("test")
	public void test() {
		Solution s = new Solution();

		char[][] c = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' }, };
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.print(String.format("%c ", c[i][j]));
			}
			System.out.println();
		}

		s.solve(c);
		System.out.println();

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.print(String.format("%c ", c[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}

	@Test
	@DisplayName("test2")
	public void test2() {
		Solution s = new Solution();
		Random r = new Random();
		char[] carr = new char[] { 'O', 'X' };
		char[][] c = new char[10][10];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j] = carr[r.nextInt(3) > 0 ? 1 : 0];
				System.out.print(String.format("%c ", c[i][j]));
			}
			System.out.println();
		}
		System.out.println();

		s.solve(c);

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.print(String.format("%c ", c[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}

}
