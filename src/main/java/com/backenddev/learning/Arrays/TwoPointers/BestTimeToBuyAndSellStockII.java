package com.backenddev.learning.Arrays.TwoPointers;

/**
 * <h2>Solution for: Best Time to Buy and Sell Stock II.</h2>
 * <p>
 * You are given an array {@code prices} where {@code prices[i]} is the price of a stock on day {@code i}.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 * </p>
 *
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use a two-pointer traversal to detect profitable upward trends.</li>
 *   <li>Whenever the current day's price is higher than the previous day's, add the difference to the profit.</li>
 *   <li>This effectively simulates buying before every increase and selling after.</li>
 * </ul>
 *
 * <h5>Example:</h5>
 * <pre>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy at 1 and sell at 5 (profit = 4), then buy at 3 and sell at 6 (profit = 3).
 * Total = 7.
 * </pre>
 *
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n)</li>
 *   <li>Space complexity: O(1)</li>
 * </ul>
 *
 * <h5>Tags:</h5>
 * Arrays, Two Pointers, Greedy
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * Returns the maximum profit possible from multiple buy-sell transactions.
     *
     * @param prices array of stock prices by day
     * @return maximum profit achievable
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit (Multiple Transactions): " + maxProfit(prices)); // 7
    }
}
