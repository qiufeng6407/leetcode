package nowcoder;

import java.util.Scanner;

public class InputArray3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			int i = 0;
			int sum = 0;
			while (i < n) {
				sum += sc.nextInt();
				i++;
			}
			System.out.println(sum);
		}
		sc.close();
	}
	
}
