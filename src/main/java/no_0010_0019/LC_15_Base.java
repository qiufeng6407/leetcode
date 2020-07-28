package no_0010_0019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 15. 三数之和
 * 
 * @author jlgc
 *
 */
public class LC_15_Base {

	/**
	 * [-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0]
	 * [-5,-5,-4,-4,-4,-2,-2,-2,0,0,0,1,1,3,4,4]
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> rs = new ArrayList<>();
		if (nums == null || nums.length < 3) return rs;
		Arrays.sort(nums);
		Set<String> exists = new HashSet<>();
		for (int i = 1; i < nums.length - 1; i++) {
			int start = i - 1, end = i + 1;
			if (nums[start] == 0 && nums[i] == 0 && exists.contains("00")) continue;
			while (start >= 0 && end < nums.length) {
				if (nums[start] > 0) {
					start--;
					continue;
				}
				if (nums[end] < 0) {
					end++;
					continue;
				}
				int sum = nums[start] + nums[i] + nums[end];
				if (sum > 0) {
					start--;
				} else if (sum < 0) {
					end++;
				} else {
					String key = String.format("%d%d", nums[start], nums[i]);
					if (!exists.contains(key)) {
						List<Integer> r = new ArrayList<>();
						r.add(nums[start]);
						r.add(nums[i]);
						r.add(nums[end]);
						rs.add(r);
						exists.add(key);
					}
					start--;
					end --;
				}
			}
		}
		return rs;
	}

	public static void main(String[] args) {
		LC_15_Base lc = new LC_15_Base();
		
		System.out.println(lc.threeSum(null));
		System.out.println(lc.threeSum(new int[] { -4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0 }));
		System.out.println(lc.threeSum(new int[] { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 }));
		System.out.println(lc.threeSum(new int[] { 0, 0, 0, 0, 0, 0 }));
		System.out.println(lc.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));

	}

}
