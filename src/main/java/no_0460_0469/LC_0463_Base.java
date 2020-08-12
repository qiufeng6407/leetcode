package no_0460_0469;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 463. 岛屿的周长
 * 
 * @author jlgc
 *
 */
public class LC_0463_Base {

	class Solution {
		int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		public int islandPerimeter(int[][] grid) {
			boolean[][] visited = new boolean[grid.length][grid[0].length];
			int i = 0, j = 0;
			while (i < grid.length && j < grid[i].length) {
				if (grid[i][j] == 1)
					break;
				if (j == grid[i].length - 1) {
					j = 0;
					i++;
				} else {
					j++;
				}
			}
			return dfs(grid, i, j, visited);
		}

		public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
			if (illegalIJ(grid, i, j) || grid[i][j] != 1 || visited[i][j]) {
				return 0;
			}
			visited[i][j] = true;
			int ans = 4;
			for (int[] direction : directions) {
				ans -= neighbour(grid, i + direction[0], j + direction[1]);
				ans += dfs(grid, i + direction[0], j + direction[1], visited);
			}
			return ans;
		}
		
		public int neighbour(int[][] grid, int i, int j) {
			if (illegalIJ(grid, i, j)) {
				return 0;
			}
			return grid[i][j];
		}

		public boolean illegalIJ(int[][] grid, int i, int j) {
			return i < 0 || i >= grid.length || j < 0 || j >= grid[i].length;
		}
	}

	@Test
	@DisplayName("test")
	public void test() {
		Solution s = new Solution();
		Assertions.assertEquals(16,
				s.islandPerimeter(new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } }));
	}

}
