package base;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Base {

	@Test
	@DisplayName("生成随机二维整数数组")
	public void test1() {
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
	}
	
	@Test
	@DisplayName("生成随机二维字符数组")
	public void test2() {
		int n = 5;
		char[] c = { 'X', 'O' };
		Random r = new Random();
		int[][] matrix = new int[n][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(String.format("%c ", (matrix[i][j] = c[r.nextInt(c.length)])));
			}
			System.out.println();
		}
		System.out.println("-----------");
	}
}
