package no_401_410;

public class LC_410_Binary {

		public int splitArray(int[] nums, int m) {
			long max = 0, min = 0;
			for (int i = 0; i < nums.length; i++) {
				min = Math.max(min, nums[i]);
				max += nums[i];
			}
			if (nums.length == m) return (int) min;
			if (m == 1) return (int) max;
			if (max == 0) return 0;
			
			while (min < max) {
				// 使用二分查找这里的判断要是min<max
				// 比如[0, 2, 0, 3, 10, 15, 0, 3, 6], m=3

				// 当mid = 27, 查找到 [0, 2, 0, 3, 10], [15, 0, 3, 6], m=2不满足条件
				// 当mid = 21, 查找到 [0, 2, 0, 3, 10], [15, 0, 3], [6]
				// 这个时候子数组总和最大值为18, 虽然也能满足m=3, 但是18实际并不是最小值
				// 所以需要将max设置为21, 并继续使用二分查找
				
				long mid = (max + min) >>> 1;
				long sumt = 0;
				int mt = 1;
				for (int i = 0; i < nums.length; i++) {
					if (sumt + nums[i] > mid) {
						sumt = nums[i];
						mt ++;
					} else {
						sumt += nums[i];
					}
				}
				System.out.println(min + " " + max + " " + mid + ", M=" + mt);
				if (mt > m) min = mid + 1; else max = mid;
			}
			if (min > Integer.MAX_VALUE || min < Integer.MIN_VALUE) return 0; else return (int) min;
		}

	public static void main(String[] args) {
		LC_410_Binary lc = new LC_410_Binary();
		System.out.println("||" + lc.splitArray(new int[] { 1, Integer.MAX_VALUE }, 1));
		System.out.println("||" + lc.splitArray(new int[] { 1, Integer.MAX_VALUE }, 2));
		System.out.println("||" + lc.splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
		System.out.println("||" + lc.splitArray(new int[] { 0, 2, 0, 3, 10, 15, 0, 3, 6 }, 3));

	}

}
