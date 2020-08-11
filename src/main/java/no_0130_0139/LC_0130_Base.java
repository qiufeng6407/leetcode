package no_0130_0139;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LC_0130_Base {

	class Solution {
		public void solve(char[][] board) {
			if (board.length < 3 || board[0].length < 3) {
				return;
			}
			Set<String> borderSet = new HashSet<>();
			for (int i = 0; i < board.length; i++) {
				dfs(board, borderSet, i, 0);
				dfs(board, borderSet, i, board[i].length - 1);
			}
			for (int i = 0; i < board[0].length; i++) {
				dfs(board, borderSet, 0, i);
				dfs(board, borderSet, board.length - 1, i);
			}
			for (int i = 1; i < board.length - 1; i++) {
				for (int j = 1; j < board[i].length - 1; j++) {
					if (board[i][j] == 'O' && !borderSet.contains(String.format("%d,%d", i, j))) {
						board[i][j] = 'X';
					}
				}
			}
		}

		public void dfs(char[][] board, Set<String> borderSet, int i, int j) {
			String key = String.format("%d,%d", i, j);
			if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O'
					|| borderSet.contains(key)) {
				return;
			}
			borderSet.add(key);
			dfs(board, borderSet, i - 1, j);
			dfs(board, borderSet, i + 1, j);
			dfs(board, borderSet, i, j - 1);
			dfs(board, borderSet, i, j + 1);
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
