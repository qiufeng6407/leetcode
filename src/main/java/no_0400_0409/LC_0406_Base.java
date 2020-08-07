package no_0400_0409;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LC_0406_Base {

	class Solution {
		public int[][] reconstructQueue(int[][] people) {
			if (people.length < 2) {
				return people;
			}
			quickSort(people, 0, people.length - 1);

			List<int[]> res = new LinkedList<>();
			res.add(people[people.length - 1]);
			for (int i = people.length - 2; i >= 0; i--) {
				if (people[i][1] > 0) {
					res.add(people[i][1], people[i]);
				} else {
					res.add(0, people[i]);
				}
			}
			return res.toArray(new int[people.length][2]);
		}

		private void quickSort(int[][] people, int low, int high) {
			if (low >= high) {
				return;
			}
			int index = part(people, low, high);

			quickSort(people, low, index - 1);
			quickSort(people, index + 1, high);
		}

		private int part(int[][] people, int low, int high) {
			int[] temp = people[low];
			while (low < high) {
				while (low < high && (people[high][0] > temp[0] || (people[high][0] == temp[0] && people[high][1] < temp[1]))) {
					high--;
				}
				if (low < high) {
					people[low] = people[high];
				}
				while (low < high && (people[low][0] < temp[0] || (people[low][0] == temp[0] && people[low][1] > temp[1]))) {
					low++;
				}
				if (low < high) {
					people[high] = people[low];
				}
			}
			people[low] = temp;
			return low;
		}
	}

	@Test
	@DisplayName("test")
	public void test() {
		Solution s = new Solution();
		int[][] people = new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		s.reconstructQueue(people);
	}

	@Test
	@DisplayName("test2")
	public void test2() {
		Solution s = new Solution();
		int[][] people = new int[][] { { 9, 0 }, { 7, 0 }, { 1, 9 }, { 3, 0 }, { 2, 7 }, { 5, 3 }, { 6, 0 }, { 3, 4 },
				{ 6, 2 }, { 5, 2 } };
		s.reconstructQueue(people);
	}

}
