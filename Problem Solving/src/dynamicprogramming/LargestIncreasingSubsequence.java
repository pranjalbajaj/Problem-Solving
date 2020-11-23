package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestIncreasingSubsequence {

	public static void main(String[] args) {
		
		int[] nums = {1,3,5,4,7};
		
		System.out.println(getCountOfMaxLengthLIS(nums));
		
		//System.out.println(printLIS(nums));
	}
	
	/*
	 *  bottom up dp
	 *  
	 *  Time: O(n^2)
	 *  Space: O(n)
	 */
	
	private static int getLengthofLIS(int[] nums) {
		
		int n = nums.length;
		
		int[] dp = new int[n];
		
		Arrays.fill(dp, 1);
		
		int maxLength = Integer.MIN_VALUE;
		
		for (int i = 1; i < n; i++) {
			
			int j = 0;
			
			while (j < i) {
				
				if (nums[j] < nums[i]) {
					
					dp[i] = Math.max(dp[i], 1 + dp[j]);
					
					if (dp[i] > maxLength) {
						
						maxLength = dp[i];
					}
				}
				
				j++;
			}
			
		}
		
		return maxLength;
	}
	
	private static int getCountOfMaxLengthLIS(int[] nums) {
		
		int n = nums.length;
		
		int[] dp = new int[n];
		
		int[] count = new int[n];
		
		Arrays.fill(dp, 1);
		
		Arrays.fill(count, 1);
		
		int maxLength = Integer.MIN_VALUE;
		
		for (int i = 1; i < n; i++) {
			
			int j = 0;
			
			while (j < i) {
				
				if (nums[j] < nums[i]) {
					
					if (dp[i] < dp[j] + 1) {
						
						dp[i] = dp[j] + 1;
						
						count[i] = count[j];
					}
					else if (dp[i] == dp[j] + 1) {
						
						count[i] += count[j];
					}
				}
				
				if (dp[i] > maxLength) {
					
					maxLength = dp[i];
				}
				
				j++;
			}
			
		}
		
		int netCount = 0;
		
		for (int i = 0; i < n; i++) {
			
			if (dp[i] == maxLength) {
				
				netCount += count[i];
			}
		}
		
		return netCount;
	}
	
	private static List<List<Integer>> printLIS(int[] nums) {
		
		int n = nums.length;
		
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		
		int maxLength = 0;
		
		for (int i = 0; i < n; i++) {
			
			tempList.add(nums[i]);
			
			int currentMax = nums[i];
			
			for (int j = i + 1; j < n; j++) {
				
				if (nums[j] > currentMax) {
					
					tempList.add(nums[j]);
					
					currentMax = nums[j];
				}
			}
			
			if (maxLength < tempList.size()) {
				
				maxLength = tempList.size();
				
				result.clear();
				
				result.add(new ArrayList<Integer>(tempList));
			}
			else if (maxLength == tempList.size()) {
				
				result.add(new ArrayList<Integer>(tempList));
			}
			
			tempList.clear();
		}
		
		return result;
	}
}
