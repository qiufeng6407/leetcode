package nowcoder;

import java.util.Scanner;

public class InputArray6 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] lines = line.split(" ");
			int i = 0;
			int sum = 0;
			while (i < lines.length) {
				sum += Integer.parseInt(lines[i]);
				i++;
			}
			System.out.println(sum);
		}
		sc.close();
	}
	
}
