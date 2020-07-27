package no_410_419;

public class LC_410_Binary {
	public int splitArray(int[] nums, int m) {
		return splitArray(nums, m, 0);
	}

	public int max(int[] nums, int from) {
		return max(nums, from, nums.length);
	}

	public int max(int[] nums, int from, int to) {
		int max = -1;
		for (int i = from; i < to; i++) {
			if (nums[i] > max)
				max = nums[i];
		}
		return max;
	}

	public int sumfrom(int[] nums, int from) {
		return sumfrom(nums, from, nums.length);
	}

	public int sumfrom(int[] nums, int from, int to) {
		int sum = 0;
		for (int i = from; i < to; i++) {
			sum += nums[i];
		}
		return sum;
	}

	public int splitArray(int[] nums, int m, int from) {
		if (m == 1) return sumfrom(nums, from);
		if (nums.length - from == m) return max(nums, from);
		int min = -1;
		for (int i = from + 1; i - from + m <= nums.length; i++) {
			int sum = sumfrom(nums, from, i);
			if (min >= 0 && sum >= min) return min;
			int child = splitArray(nums, m - 1, i);
			int thismin = Math.max(sum, child);
			if (min < 0 || thismin < min) min = thismin;
		}
		return min;
	}

	public static void main(String[] args) {
		LC_410_Binary lc = new LC_410_Binary();

		System.out.println("||" + lc.splitArray(new int[] { 2, 3, 1, 2, 4, 3 }, 5));
		System.out.println("||" + lc.splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
		System.out.println("||" + lc.splitArray(new int[] { 0, 2, 0, 3, 10, 15, 0, 3, 6 }, 3));

	}

}
