package ms;

import org.junit.jupiter.api.Test;

/**
 * 面试题 10.11. 峰与谷
 * 
 * 
 * @author jlgc
 *
 */
public class MS_10_11_Base {
	
	class Solution {
	    public void wiggleSort(int[] nums) {
	    	for (int i = 1; i < nums.length;i++) {
	    		if ((i & 1) == 0) {
	    			if (nums[i] < nums[i - 1]) swap(nums, i, i - 1);
	    		} else {
	    			if (nums[i] > nums[i - 1]) swap(nums, i, i - 1);
	    		}
	    	}
	    }
	    
	    private void swap(int[] nums, int i, int j) {
    		int temp = nums[i];
    		nums[i] = nums[j];
    		nums[j] = temp;
	    }
	}
	
	@Test
	public void test() {
		Solution s = new Solution();
		s.wiggleSort(new int[] { 0, 2, 3, 4, 5 });
		s.wiggleSort(new int[] { 1, 1, 1 });
	}
	
}
