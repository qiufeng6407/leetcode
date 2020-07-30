package ms;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 面试题 08.10. 颜色填充
 * @author jlgc
 *
 */
public class MS_08_01_Base {
	
	class Solution {
		@SuppressWarnings("unchecked")
		public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
			if (n == 0) {
				return false;
			}
			List<Integer>[] nodes = new ArrayList[n];
			for (int i = 0; i < graph.length; i++) {
				if (graph[i][0] == start && graph[i][1] == target) {
					return true;
				}
				if (start == target && graph[i][0] == graph[i][1] && start == graph[i][0]) {
					return true;
				}
				if (nodes[graph[i][0]] == null) {
					nodes[graph[i][0]] = new ArrayList<>();
				}
				nodes[graph[i][0]].add(graph[i][1]);
			}
			boolean[] visited = new boolean[n];
			return dfs(nodes, start, target, visited);
		}

		public boolean dfs(List<Integer>[] nodes, int idx, int target, boolean[] visited) {
			visited[idx] = true;
			if (nodes[idx] == null) {
				return false;
			}
			for (int n : nodes[idx]) {
				if (visited[n]) {
					continue;
				}
				if (n == target) {
					return true;
				}
				if (dfs(nodes, n, target, visited)) {
					return true;
				}
			}
			return false;
		}
	}
	
	@Test
	public void test() {
		Solution s = new Solution();
		Assertions.assertTrue(s.findWhetherExistsPath(3, new int[][] { {0, 1}, {0, 2}, {1, 2}, {1, 2} }, 0, 2));
	}
	
}
