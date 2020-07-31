package no_1510_1519;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 1518. 换酒问题
 * @author jlgc
 *
 */
public class LC_1518_Base {
	class Solution {
	    public int numWaterBottles(int numBottles, int numExchange) {
	    	int total = numBottles;
	    	while (numBottles >= numExchange) {
	    		int newNum = numBottles / numExchange;
	    		total += newNum;
	    		numBottles = numBottles % numExchange + newNum;
	    	}
	    	return total;
	    }
	}

	@Test
	public void test() {
		Solution s = new Solution();

		Assertions.assertEquals(13, s.numWaterBottles(9, 3));
		Assertions.assertEquals(19, s.numWaterBottles(15, 4));
		Assertions.assertEquals(3, s.numWaterBottles(3, 4));
		Assertions.assertEquals(5, s.numWaterBottles(4, 4));
		Assertions.assertEquals(5, s.numWaterBottles(4, 4));
		Assertions.assertEquals(0, s.numWaterBottles(0, 4));
		Assertions.assertEquals(2, s.numWaterBottles(2, 3));
	}

}
