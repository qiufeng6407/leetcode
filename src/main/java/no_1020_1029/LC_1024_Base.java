package no_1020_1029;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author jlgc
 *
 */
public class LC_1024_Base {

	class Solution {
		public int videoStitching(int[][] clips, int T) {
			if (T == 0) return 0;
			Arrays.sort(clips, Comparator.comparingInt(o -> o[0]));
			
			int i = 0, S = 0, step = 0;
			while (i < clips.length) {
				int currS = -1;
				while (i < clips.length && clips[i][0] <= S) {
					currS = Math.max(currS, clips[i][1]);
					i++;
				}
				if (currS == -1) {
					return -1;
				}
				S = currS;
				step ++;
				if (S >= T) {
					return step;
				}
			}
			return -1;
		}
	}

	@Test
	@DisplayName("3")
	public void test1() {
		Solution s = new Solution();
		Assertions.assertEquals(-1, s.videoStitching(new int[][] { { 0, 2 }, { 4, 8 } }, 5));
		Assertions.assertEquals(3,
				s.videoStitching(new int[][] { { 0, 2 }, { 4, 6 }, { 8, 10 }, { 1, 9 }, { 1, 5 }, { 5, 9 } }, 10));
		Assertions.assertEquals(-1,
				s.videoStitching(new int[][] { { 0, 1 }, { 6, 8 }, { 0, 2 }, { 5, 6 }, { 0, 4 }, { 0, 3 }, { 6, 7 },
						{ 1, 3 }, { 4, 7 }, { 1, 4 }, { 2, 5 }, { 2, 6 }, { 3, 4 }, { 4, 5 }, { 5, 7 }, { 6, 9 } },
						10));
		Assertions.assertEquals(3,
				s.videoStitching(new int[][] { { 0, 1 }, { 6, 8 }, { 0, 2 }, { 5, 6 }, { 0, 4 }, { 0, 3 }, { 6, 7 },
						{ 1, 3 }, { 4, 7 }, { 1, 4 }, { 2, 5 }, { 2, 6 }, { 3, 4 }, { 4, 5 }, { 5, 7 }, { 6, 9 } },
						9));
		Assertions.assertEquals(-1, s.videoStitching(new int[][] { { 0, 1 }, { 1, 2 } }, 5));
		Assertions.assertEquals(2, s.videoStitching(new int[][] { { 0, 4 }, { 2, 8 } }, 5));
		Assertions.assertEquals(-1, s.videoStitching(new int[][] { { 0, 4 } }, 5));
		Assertions.assertEquals(1, s.videoStitching(new int[][] { { 0, 4 } }, 4));
		Assertions.assertEquals(-1, s.videoStitching(new int[][] { }, 4));
		Assertions.assertEquals(0, s.videoStitching(new int[][] { { 0, 4 } }, 0));
		Assertions.assertEquals(0, s.videoStitching(new int[][] { }, 0));
	}

}
