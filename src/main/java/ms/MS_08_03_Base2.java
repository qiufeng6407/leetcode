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
public class MS_08_03_Base2 {
	
	class Solution {
	    public int findMagicIndex(int[] nums) {
	    	if (nums == null || nums.length == 0) return -1;
	    	int i = 0;
	    	while (i < nums.length) {
	    		if (i == nums[i]) return i;
	    		if (nums[i] > i) {
	    			i += nums[i] - i; // 即 i = nums[i]
	    		} else if (nums[i] < 0) {
	    			i++;
	    		} else {
	    			return -1;
	    		}
	    	}
	    	return -1;
	    }
	}
	
	@Test
	public void test() {
		Solution s = new Solution();
		Assertions.assertEquals(22, s.findMagicIndex(new int[] { -531369933, -469065528, -430059048, -428981853, -319235969, -288076332, -286667432, -282312559, -197049680, -197022263, -174416117, -138027773, -121899023, -111631966, -107567458, -70437707, -52463072, -45519851, -38641451, -15825815, -3835472, -1525043, 22, 566842886, 593757472, 605439236, 619794079, 640069993, 657657758, 718772950, 815849552, 839357142, 936585256, 1006188278, 1042347147, 1057129320, 1062178586, 1069769438 }));
		Assertions.assertEquals(6, s.findMagicIndex(new int[] { 3, 5, 5, 5, 5, 6, 6, 9, 9, 10, 10, 100, 110, 120, 130, 145 }));
//		Assertions.assertEquals(1, s.findMagicIndex(new int[] { 1, 1, 1 }));
//		Assertions.assertEquals(0, s.findMagicIndex(new int[] { 0, 2, 3, 4, 5 }));
	}
	
}
