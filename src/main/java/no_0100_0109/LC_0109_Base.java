package no_0100_0109;

import java.util.ArrayList;
import java.util.List;

public class LC_0109_Base {
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
	
	class Solution {
	    public TreeNode sortedListToBST(ListNode head) {
	    	if (head == null) return null;
	    	List<ListNode> list = new ArrayList<>();
    		list.add(head);
	    	ListNode curr = head;
	    	while (curr.next != null) {
	    		list.add(curr.next);
	    		curr = curr.next;
	    	}
	    	ListNode[] arr = list.toArray(new ListNode[0]);
	        return sortedListToBST(arr, 0, arr.length);
	    }
	    
	    public TreeNode sortedListToBST(ListNode[] arr, int from , int to) {
	    	if (from < 0 || to > arr.length || from >= to) {
	    		return null;
	    	}
	    	int index = (from + to) / 2;
	    	TreeNode node = new TreeNode(arr[index].val);
	    	node.left = sortedListToBST(arr, from, index);
	    	node.right = sortedListToBST(arr, index + 1, to);
	    	return node;
	    }
	}

}
