package nowcoder;

import java.util.Scanner;

public class InputArray5 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int sum = 0;
			int i = 0;
			while (i < n) {
				sum += sc.nextInt();
				i++;
			}
			System.out.println(sum);
		}
		sc.close();
	}
	
}
