package dynamicprogramming;
/**
 * JUMP GAME
 * 
 * You are at position 0 of the array and the objective of the game is
 * to reach the end of the array in minimum number of jumps.
 * 
 *  The value at any index of the array represents the maximum number of
 *  jumps a player can take from that position.
 */

import java.util.Arrays;

public class JumpGame {

	public static void main(String[] args) {

		int[] nums = { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };

		System.out.println(jumpOpt(nums));
	}

	public static int jump(int[] nums) {

		int[] dp = new int[nums.length];

		Arrays.fill(dp, Integer.MAX_VALUE - 1);

		dp[0] = 0;

		for (int i = 1; i < nums.length; i++) {

			for (int j = 0; j < i; j++) {

				if (nums[j] + j >= i) {

					dp[i] = Math.min(dp[i], 1 + dp[j]);
				}
			}
		}

		return dp[nums.length - 1];
	}

	public static int jumpOpt(int[] nums) {
		
		if (nums.length == 0 || nums.length == 1) {
			
			return 0;
		}
		
		int i = 0;
		
		int jumps = 0;
		
		while (i + nums[i] < nums.length - 1) {
			
			int temp = 0;
			
			int nxtIdx = 0;
			
			for (int j = i + 1; j <= i + nums[i]; j++) {
				
				if (j + nums[j] > temp) {
					
					temp = j + nums[j];
					
					nxtIdx = j;
				}
			}
			
			i = nxtIdx;
			
			jumps++;
		}
		
		return jumps + 1;
	}
	
}
