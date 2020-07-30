package ms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * 面试题 04.01. 节点间通路
 * 
 * @author jlgc
 *
 */
public class MS_04_01_Base {

	class Solution {
		public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
			if (image == null || image.length == 0 || image[sr][sc] == newColor) {
				return image;
			}
			boolean[][] visited = new boolean[image.length][image[0].length];
			bfs(image, sr, sc, newColor, visited);
			return image;
		}
		
		public void bfs(int[][] image, int sr, int sc, int newColor, boolean[][] visited) {
			Queue<int[]> q = new LinkedList<int[]>();
			q.offer(new int[] { sr, sc });
			int oldColor = image[sr][sc];
			
			while (!q.isEmpty()) {
				int[] curr = q.poll();
				int r = curr[0], c = curr[1];
				if (visited[r][c]) continue;
				if (image[r][c] == oldColor) {
					image[r][c] = newColor;
					visited[r][c] = true;
				}
				if (r > 0 && image[r - 1][c] == oldColor && !visited[r - 1][c]) {
					q.offer(new int[] { r - 1, c });
				}
				if (r < image.length - 1 && image[r + 1][c] == oldColor && !visited[r + 1][c]) {
					q.offer(new int[] { r + 1, c });
				}
				if (c > 0 && image[r][c - 1] == oldColor && !visited[r][c - 1]) {
					q.offer(new int[] { r, c - 1 });
				}
				if (c < image[0].length - 1 && image[r][c + 1] == oldColor && !visited[r][c + 1]) {
					q.offer(new int[] { r, c + 1 });
				}
			}
		}
	}

	@Test
	public void test() {
		Solution s = new Solution();
		int[][] image = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				System.out.print(String.format("%02d ", image[i][j]));
			}
			System.out.println();
		}
		image = s.floodFill(image, 1, 1, 2);
		System.out.println("-----------");
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				System.out.print(String.format("%02d ", image[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}
	
	@Test
	public void test2() {
		Solution s = new Solution();
		int[][] image = new int[10][12];
		Random r = new Random();
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				System.out.print(String.format("%d ", image[i][j] = r.nextInt(2)));
			}
			System.out.println();
		}
		image = s.floodFill(image, 1, 1, 2);
		System.out.println("-----------");
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				System.out.print(String.format("%d ", image[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}

}
