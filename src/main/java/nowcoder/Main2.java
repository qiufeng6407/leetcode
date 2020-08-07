package nowcoder;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String target = sc.nextLine();
		String source = sc.nextLine();
		sc.close();
		
		if (source.length() == 0 || target.length() == 0) {
			System.out.println(-1);
			return;
		}
		int i = source.length() - 1, j = target.length() - 1;
		while (i >= 0) {
			if (source.charAt(i) == target.charAt(j)) {
				if (j == 0) {
					break;
				}
				j --;
			}
			i --;
		}
		System.out.println(i);
	}

}
