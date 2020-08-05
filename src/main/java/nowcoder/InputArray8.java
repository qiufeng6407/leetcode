package nowcoder;

import java.util.Arrays;
import java.util.Scanner;

public class InputArray8 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String[] arr = sc.nextLine().split(" ");
			Arrays.sort(arr);
			int i = 0;
			while (i < arr.length) {
				if (i > 0) 
					System.out.print(" ");
				System.out.print(arr[i]);
				i++;
			}
			System.out.println();
		}
		sc.close();
	}
	
}
