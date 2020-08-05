package nowcoder;

import java.util.Arrays;
import java.util.Scanner;

public class InputArray7 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] arr = new String[n];
		int i = 0;
		while (i < n) {
			arr[i] = sc.next();
			i++;
		}
		Arrays.sort(arr);
		i = 0;
		while (i < n) {
			System.out.print(arr[i] + " ");
			i++;
		}
		sc.close();
	}
	
}
