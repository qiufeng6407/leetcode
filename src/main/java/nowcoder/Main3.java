package nowcoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main3 {
	
	private static String random(int len) {
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len * len; i++) {
			int x = r.nextInt(2);
			if (i != 0 && i % len == 0) {
				System.out.println();
			}
			System.out.print(" " + x);
			sb.append(x).append(",");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();
		
//		line = random(6);
		
		if (line.length() == 0) {
			System.out.println(-1);
			return;
		}
		String[] temp = line.split(",");
		int n = (int) Math.sqrt(temp.length);
		char[][] arr = new char[n][n];
		List<Integer[]> virList = new ArrayList<>();
		for (int i = 0; i < temp.length; i++) {
			int r = i / n;
			int c = i % n;
			arr[r][c] = temp[i].charAt(0);
			if (arr[r][c] == '1') {
				virList.add(new Integer[] { r, c });
			}
		}
		
		if (virList.isEmpty() || virList.size() == n * n) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(flow(arr, virList));
	}
	
	public static int flow(char[][] arr, List<Integer[]> virList) {
		List<Integer[]> newVirList = new ArrayList<>();
		Iterator<Integer[]> it = virList.iterator();
		while (it.hasNext()) {
			Integer[] pos = it.next();
			if (pos[0] > 0 && arr[pos[0] - 1][pos[1]] == '0') { // LEFT
				newVirList.add(new Integer[] { pos[0] - 1, pos[1] });
				arr[pos[0] - 1][pos[1]] = '1';
			}
			if (pos[0] < arr.length - 1 && arr[pos[0] + 1][pos[1]] == '0') { // RIGHT
				newVirList.add(new Integer[] { pos[0] + 1, pos[1] });
				arr[pos[0] + 1][pos[1]] = '1';
			}
			if (pos[1] > 0 && arr[pos[0]][pos[1] - 1] == '0') { // TOP
				newVirList.add(new Integer[] { pos[0], pos[1] - 1 });
				arr[pos[0]][pos[1] - 1] = '1';
			}
			if (pos[1] < arr.length - 1 && arr[pos[0]][pos[1] + 1] == '0') { // BOTTOM
				newVirList.add(new Integer[] { pos[0], pos[1] + 1 });
				arr[pos[0]][pos[1] + 1] = '1';
			}
		}
		if (newVirList.isEmpty()) {
			return 0;
		}
		return flow(arr, newVirList) + 1;
	}

}
