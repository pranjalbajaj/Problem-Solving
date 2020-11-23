/**
 * Design an algorithm to find the maximum profit. You may complete at most K transactions.
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
package dynamicprogramming;

public class BestTimeToBuyAndSellStock3 {

	public static void main(String[] args) {

		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };

		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {

		return profitMemoryOpt(prices, 2);
	}

	/**
	 * Time: O(k*n^2) Space: O(k*n)
	 * 
	 * @param prices
	 * @param k
	 * @return
	 */
	private static int profit(int[] prices, int k) {

		int n = prices.length;
		int[][] dp = new int[k + 1][n];

		for (int i = 1; i <= k; i++) {

			for (int j = 1; j < n; j++) {

				for (int x = j - 1; x >= 0; x--) {

					dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][j - 1], prices[j] - prices[x] + dp[i - 1][x]));
				}
			}
		}

		return dp[k][n - 1];
	}

	/**
	 * Time: O(n*k) Space: O(n*k)
	 * 
	 * @param prices
	 * @param k
	 * @return
	 */
	private static int profitOpt(int[] prices, int k) {

		int n = prices.length;
		int[][] dp = new int[k + 1][n];

		for (int i = 1; i <= k; i++) {

			int maxdiff = dp[i - 1][0] - prices[0];

			for (int j = 1; j < n; j++) {

				dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][j - 1], prices[j] + maxdiff));

				maxdiff = Math.max(maxdiff, dp[i - 1][j] - prices[j]);
			}
		}

		return dp[k][n - 1];
	}
	
	/**
	 * Time: O(n*k)
	 * Space: O(2*n)
	 * @param prices
	 * @param k
	 * @return
	 */
	private static int profitMemoryOpt(int[] prices, int k) {

		int n = prices.length;
		int[][] dp = new int[2][n];

		for (int i = 1; i <= k; i++) {

			int maxdiff = dp[0][0] - prices[0];

			for (int j = 1; j < n; j++) {

				dp[1][j] = Math.max(dp[1][j], Math.max(dp[1][j - 1], prices[j] + maxdiff));

				maxdiff = Math.max(maxdiff, dp[0][j] - prices[j]);
			}

			if (i != k) {
				for (int m = 0; m < n; m++) {

					dp[0][m] = dp[1][m];

					dp[1][m] = 0;
				}
			}
		}

		return dp[1][n - 1];
	}
}
