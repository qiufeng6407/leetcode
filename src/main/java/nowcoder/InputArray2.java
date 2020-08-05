package nowcoder;

import java.util.Scanner;

public class InputArray2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] arr = new int[t][2];
		int i = 0;
		while (i < t) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			i++;
		}
		for (i = 0; i < t; i++) {
			System.out.println(arr[i][0] + arr[i][1]);
		}
		sc.close();
	}
	
}
