package base;

import java.util.Random;

public class Lc {

	protected void printIntArray(int[] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(String.format("%02d ", matrix[i]));
		}
		System.out.println();
	}

	protected void printIntArray(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(String.format("%02d ", matrix[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}

	protected int[][] randomIntArray(int length, int length2) {
		Random r = new Random();
		int[][] matrix = new int[length][length2];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = r.nextInt(100);
			}
		}
		return matrix;
	}
}
