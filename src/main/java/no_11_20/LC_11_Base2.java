package no_11_20;

public class LC_11_Base2 {

	public int maxArea(int[] height) {
		if (height == null || height.length < 2)
			return 0;
		int start = 0, end = height.length - 1, area = 0;
		while (start < end) {
			if (height[start] > height[end]) {
				area = Math.max(area, (end - start) * height[end]);
				end --;
			} else {
				area = Math.max(area, (end - start) * height[start]);
				start ++;
			}
		}
		return area;
	}

	public static void main(String[] args) {
		LC_11_Base2 lc = new LC_11_Base2();

		assert lc.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }) == 49 : "";

	}

}
