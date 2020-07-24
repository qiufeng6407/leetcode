package no_11_20;

public class LC_11_Base {

	public int maxArea(int[] height) {
		if (height == null || height.length < 2)
			return 0;
		int area = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
			}
		}
		return area;
	}

	public static void main(String[] args) {
		LC_11_Base lc = new LC_11_Base();

		assert lc.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }) == 49 : "";

	}

}
