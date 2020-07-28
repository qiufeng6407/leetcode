package no_0320_0329;

import java.util.Random;

public class LC_329_Base {

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		final int w = matrix.length;
		final int h = matrix[0].length;
		final int[][][] dp = new int[w][h][4];
		int max = 1;
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				int temp = longestIncreasingPath(matrix, dp, i, j);
				if (temp > max) {
					System.out.println(String.format("             set max=%d, i=%d, j=%d", max, i, j));
				}
				max = Math.max(max, temp);
			}
		}
		return max;
	}

	public int longestIncreasingPath(int[][] matrix, final int[][][] dp, int i, int j) {
		final int h = matrix.length;
		final int w = matrix[0].length;
		int max = 1;
		if (dp[i][j][0] == 0) {
			if (i == 0 || matrix[i - 1][j] <= matrix[i][j]) {
				dp[i][j][0] = 1; // 最上一行
			} else {
				dp[i][j][0] = longestIncreasingPath(matrix, dp, i - 1, j) + 1;
			}
		}
		max = Math.max(max, dp[i][j][0]);
		if (dp[i][j][1] == 0) {
			if (j == w - 1 || matrix[i][j] >= matrix[i][j + 1]) {
				dp[i][j][1] = 1; // 最上一行
			} else {
				dp[i][j][1] = longestIncreasingPath(matrix, dp, i, j + 1) + 1;
			}
		}
		max = Math.max(max, dp[i][j][1]);
		if (dp[i][j][2] == 0) {
			if (i == h - 1 || matrix[i][j] >= matrix[i + 1][j]) {
				dp[i][j][2] = 1; // 最上一行
			} else {
				dp[i][j][2] = longestIncreasingPath(matrix, dp, i + 1, j) + 1;
			}
		}
		max = Math.max(max, dp[i][j][2]);
		if (dp[i][j][3] == 0) {
			if (j == 0 || matrix[i][j] >= matrix[i][j - 1]) {
				dp[i][j][3] = 1; // 最上一行
			} else {
				dp[i][j][3] = longestIncreasingPath(matrix, dp, i, j - 1) + 1;
			}
		}
		max = Math.max(max, dp[i][j][3]);
		return max;
	}

	public static void main(String[] args) {
		LC_329_Base lc = new LC_329_Base();

		Random r = new Random(); 
		
		int[][] nums = new int[5][5];
		for (int i = 0; i < nums.length; i ++) {
			for (int j = 0; j < nums[0].length; j++) {
				nums[i][j] = r.nextInt(100);
				System.out.print(String.format("%02d ", nums[i][j]));
			}
			System.out.println();
		}
		System.out.println("==============" + lc.longestIncreasingPath(nums));
	}

}
