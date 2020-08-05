package nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class HJ77 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int i = 0;
			while (i < n) {
				arr[i] = sc.nextInt();
				i++;
			}
			Stack<Integer> stack = new Stack<>();
			List<String> res = new ArrayList<>();
			
			traceback(arr, 0, 0, "", res, stack);
			
			Collections.sort(res);
			
			for (String str : res) {
				System.out.println(str);
			}
			
		}
		sc.close();
	}
	
	public static void traceback(int[] arr, int idx, int len, String curr, List<String> res, Stack<Integer> stack) {
		if (len == arr.length) {
			res.add(curr.trim());
			return;
		}
		
		if (idx < arr.length) {
			stack.push(arr[idx]);
			traceback(arr, idx + 1, len, curr, res, stack);
			stack.pop();
		}
		
		if (!stack.isEmpty()) {
			int temp = stack.pop();
			traceback(arr, idx, len + 1, curr + " " + temp, res, stack);
			stack.push(temp);
		}
	}
	
}
