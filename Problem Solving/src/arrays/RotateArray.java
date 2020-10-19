/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * 
 * Constraint: do it in O(1) space
 * 
 * Approach : We will use juggling algorithm to solve this.
 * 			  (There will be cycles in the algorithm if length
 * 				of array is a multiple of k)
 * 
 * 
 */

package arrays;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		
		int[] nums = new int[] {1,2,3,4,5,6,7};
		
		int k = 3;
		
		rotate(nums, k);
		
		System.out.println(Arrays.toString(nums));

	}

	public static void rotate(int[] nums, int k) {

		if (nums.length > 1) {

			k = k % nums.length;

			int cnt = 0;

			int idx = 0;

			// loop 1 to identify if we have juggled all the elements
			while (cnt < nums.length) {

				int start = idx;

				int end = -1;

				int ele = nums[idx];

				// loop 2 if there are cycles
				while (start != end) {

					int moveIdx = idx + k;

					if (moveIdx >= nums.length) {

						moveIdx -= nums.length;
					}

					int nxt = nums[moveIdx];

					nums[moveIdx] = ele;

					ele = nxt;

					idx = moveIdx;

					end = idx;

					cnt++;
				}

				idx++;
			}

		}
	}

}
