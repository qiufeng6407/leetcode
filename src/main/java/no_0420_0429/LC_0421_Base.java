package no_0420_0429;

import java.util.HashSet;
import java.util.Set;

/**
 * 421. 数组中两个数的最大异或值
 * @author jlgc
 *
 */
public class LC_0421_Base {

    public int findMaximumXOR(int[] nums) {
    	if (nums.length < 2) return 0;
    	if (nums.length == 2) return nums[0] ^ nums[1];
    	int max = nums[0];
		for (int i = 1; i < nums.length; i++) max = Math.max(max, nums[i]);
		int maxLen = Integer.toBinaryString(max).length();
		int maxXor = 0, currXor = 0;
		 Set<Integer> prefixes = new HashSet<>();
		for (int i = maxLen - 1; i >= 0; i--) {
			maxXor = maxXor << 1;
			currXor = maxXor | 1;

			// 判断集合中是否有两个数的前缀 p1, p2, 使得 p1 ^ p2 = currXor
			// 即 p2 = currXor ^ p1, 由于currXor != 0, 所以不存在 p1 == p2的情况
			// 所以只要去Set中查找是否存在 currXor ^ p1, 就能知道是否存在存在一个p2使得条件成立
			for (int num : nums) prefixes.add(num >> i);
			for (int p : prefixes) {
				if (prefixes.contains(p ^ currXor)) {
					maxXor = currXor;
					break;
				}
			}
			prefixes.clear();
			
		}
		return maxXor;
    }

	public static void main(String[] args) {
		LC_0421_Base lc = new LC_0421_Base();

		System.out.println(lc.findMaximumXOR( new int[] { 3, 10, 5, 25, 2, 8 }));

	}

}
