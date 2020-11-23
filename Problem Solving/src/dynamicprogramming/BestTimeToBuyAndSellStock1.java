/**
 * If you were only permitted to complete at most one transaction 
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * 
 * Time : O(n)
 * Space: O(1)
 */
package dynamicprogramming;

public class BestTimeToBuyAndSellStock1 {

	public static void main(String[] args) {
		
		int[] prices = {7,1,5,3,6,4};
		
		System.out.println(maxProfit(prices));
		
	}

	private static int maxProfit(int[] prices) {
		
		if (prices.length == 0) return 0;
		
		int maxProfit = 0;
		int minPrice = prices[0];
		
		for (int i = 1; i < prices.length; i++) {
			
			if (prices[i] < minPrice)
				minPrice = prices[i];
			else if (prices[i] - minPrice > maxProfit)
				maxProfit = prices[i] - minPrice;
		}
		
		return maxProfit;
	}
}