package ms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 面试题 08.03. 魔术索引
 * 
 * 
 * @author jlgc
 *
 */
public class MS_08_03_Base {
	
	class Solution {
	    public int findMagicIndex(int[] nums) {
	    	if (nums == null || nums.length == 0) return -1;
	    	for (int i = 0; i < nums.length; i++) {
	    		if (i == nums[i]) return i;
	    	}
	    	return -1;
	    }
	}
	
	@Test
	public void test() {
		Solution s = new Solution();
		Assertions.assertEquals(0, s.findMagicIndex(new int[] { 0, 2, 3, 4, 5 }));
		Assertions.assertEquals(1, s.findMagicIndex(new int[] { 1, 1, 1 }));
	}
	
}
