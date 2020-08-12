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
public class LC_0463_Base3 {

	class Solution {
		int[][] directions = new int[][] { { 0, -1 }, { -1, 0 } };
		public int islandPerimeter(int[][] grid) {
			int ans = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if (grid[i][j] == 1) {
						ans += 4;
						for (int[] direction : directions) {
							ans -= neighbour(grid, i + direction[0], j + direction[1]);
						}
					}
				}
			}
			return ans;
		}
		
		public int neighbour(int[][] grid, int i, int j) {
			if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
				return 0;
			}
			return grid[i][j] == 0 ? 0 : 2;
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
