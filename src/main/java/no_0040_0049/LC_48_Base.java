package no_0040_0049;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 48. 旋转图像
 * 
 * @author jlgc
 *
 */
public class LC_48_Base {

	class Solution {
		public void rotate(int[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix.length == 1)
				return;
			rotate(matrix, 0);
		}

		public void rotate(int[][] matrix, int dep) {
			int n = matrix.length;
			for (int i = dep; i < n - dep - 1; i++) {
				// 上：matrix[dep ][i ]
				// 右：matrix[i ][n - dep - 1]
				// 下：matrix[n - dep - 1][n - i - 1 ]
				// 左：matrix[n - i - 1 ][dep ]
				int temp = matrix[dep][i];
				matrix[dep][i] = matrix[n - i - 1][dep];
				matrix[n - i - 1][dep] = matrix[n - dep - 1][n - i - 1];
				matrix[n - dep - 1][n - i - 1] = matrix[i][n - dep - 1];
				matrix[i][n - dep - 1] = temp;
			}
			if (dep < matrix.length / 2)
				rotate(matrix, ++dep);
		}
	}

	@Test
	@DisplayName("3")
	public void test1() {
		Solution s = new Solution();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(String.format("%02d ", matrix[i][j]));
			}
			System.out.println();
		}
		System.out.println("-----------");
		s.rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(String.format("%02d ", matrix[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}

	@Test
	@DisplayName("4")
	public void test2() {
		Solution s = new Solution();
		int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(String.format("%02d ", matrix[i][j]));
			}
			System.out.println();
		}
		System.out.println("-----------");
		s.rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(String.format("%02d ", matrix[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}

	@Test
	@DisplayName("n")
	public void testn() {
		Solution s = new Solution();
		int n = 5;
		Random r = new Random();
		int[][] matrix = new int[n][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(String.format("%02d ", (matrix[i][j] = r.nextInt(100))));
			}
			System.out.println();
		}
		System.out.println("-----------");
		s.rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(String.format("%02d ", matrix[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}

}
