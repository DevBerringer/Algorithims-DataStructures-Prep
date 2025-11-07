package com.backenddev.learning.Arrays.Greedy;

/**
 * <h2>Solution for: Best Time to Buy and Sell Stock.</h2>
 * <p>
 * Given an array where the i-th element represents the price of a stock on day i,
 * find the maximum profit achievable from a single buy and a single sell.
 * The buy must occur before the sell.
 * </p>
 *
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Track the minimum price seen so far.</li>
 *   <li>For each price, compute the potential profit if sold today.</li>
 *   <li>Update the maximum profit whenever a larger one is found.</li>
 * </ul>
 *
 * <h5>Example:</h5>
 * <pre>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy at 1, sell at 6, profit = 5.
 * </pre>
 *
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n)</li>
 *   <li>Space complexity: O(1)</li>
 * </ul>
 *
 * <h5>Tags:</h5>
 * Arrays, Two Pointers, Dynamic Tracking, Greedy
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Returns the maximum profit possible from one buy-sell transaction.
     *
     * @param prices array of stock prices by day
     * @return maximum profit possible
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + maxProfit(prices)); // 5
    }
}
