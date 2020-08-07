package nowcoder;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("/acm,/bb".replaceFirst("/*,/*", "/"));
		System.out.println("/acm/,/bb".replaceFirst("/*,/*", "/"));
		System.out.println("/acm/,bb".replaceFirst("/*,/*", "/"));
		System.out.println("/acm,bb".replaceFirst("/*,/*", "/"));
		System.out.println("/acm//,//bb".replaceFirst("/*,/*", "/"));
		System.out.println(",".replaceFirst("/*,/*", "/"));
		System.out.println("/,".replaceFirst("/*,/*", "/"));
		System.out.println("/,/".replaceFirst("/*,/*", "/"));
		System.out.println("/////,/////".replaceFirst("/*,/*", "/"));
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		System.out.println(line.replaceFirst("/*,/*", "/"));
		sc.close();
	}

}
