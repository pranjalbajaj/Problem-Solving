/**
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
package dynamicprogramming;

public class BestTimeToBuyAndSellStock2 {

	public static void main(String[] args) {
		
		int[] prices = {7,1,5,3,6,4};
		
		System.out.println(maxProfit(prices));
	}

	private static int maxProfit(int[] prices) {

		int n = prices.length;
		int buy = prices[0];
		int sell = prices[0];
		int maxProfit = 0;

		int i = 0;

		while (i < n - 1) {

			while (i < n - 1 && prices[i] >= prices[i + 1])
				i++;
			buy = prices[i];

			while (i < n - 1 && prices[i] <= prices[i + 1])
				i++;
			sell = prices[i];

			maxProfit += sell - buy;
		}

		return maxProfit;
	}
}
