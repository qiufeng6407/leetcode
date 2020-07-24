package a;

/**
 * 输入4个整数，在不改变输入顺序的前提下，求出其最大的三位数；3, 2, 1, 4  -> 324
 * @author jlgc
 *
 */
public class Max3LengthNumber {
	
	public static int max(int[] ints) {
		int max = 0;
		if (ints[0] >= ints[1]) {
			max += ints[0] * 100;
			if (ints[1] > ints[2]) {
				max += ints[1] * 10;
				max += Math.max(ints[2], ints[3]);
			} else {
				max += ints[2] * 10;
				max += ints[3];
			}
		} else {
			max += ints[1] * 100;
			max += ints[2] * 10;
			max += ints[3];
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(max(new int[] { 1, 2, 3, 4 }));
		System.out.println(max(new int[] { 3, 2, 1, 4 }));
		System.out.println(max(new int[] { 1, 1, 1, 2 }));
		System.out.println(max(new int[] { 0, 1, 2, 3 }));
		System.out.println(max(new int[] { 3, 3, 1, 0 }));
		System.out.println(max(new int[] { 1, 3, 3, 4 }));
	}
}
