package nowcoder;

import java.util.Scanner;

public class InputArray4 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		while (i < n) {
			int a = sc.nextInt();
			int sum = 0;
			int j = 0;
			while (j < a) {
				sum += sc.nextInt();
				j++;
			}
			System.out.println(sum);
			i++;
		}
		sc.close();
	}
	
}
