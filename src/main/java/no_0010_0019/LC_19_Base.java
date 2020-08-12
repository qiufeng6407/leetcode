package no_0010_0019;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LC_19_Base {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			ListNode nodeN_1 = null;
			int i = 1;
			ListNode curr = head;
			while (curr != null) {
				if (i == n + 1) {
					nodeN_1 = head;
				} else if (i > n) {
					nodeN_1 = nodeN_1.next;
				}
				i++;
				curr = curr.next;
			}
			if (nodeN_1 == null) {
				return head.next;
			} else {
				nodeN_1.next = nodeN_1.next.next;
			}
			return head;
		}
	}
	


	@Test
	@DisplayName("test")
	public void test() {
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		ListNode curr = head;
		for (int i = 2; i <= 10; i++) {
			curr.next = new ListNode(i);
			curr = curr.next;
		}
		curr = head;
		do {
			System.out.print(String.format("%d -> ", curr.val));
			curr = curr.next;
		} while (curr != null);
		System.out.println();

		head = s.removeNthFromEnd(head, 1);
		
		curr = head;
		do {
			System.out.print(String.format("%d -> ", curr.val));
			curr = curr.next;
		} while (curr != null);
		System.out.println();
	}

}
