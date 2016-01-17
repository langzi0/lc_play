package CodePad;

import java.util.Arrays;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of
 * the stock), design an algorithm to find the maximum profit.
 */

public class BestTimetoBuyandSellStock_ex extends InvokableBase {

  @Override
  public Priority getRunPriority() {

    return new Priority(/*yymdd*/151028, 1, Category.LeetCode);
  }

  @Override
  public void run() {
    int[] prices = new int[]{1, 2, 3, 1, 1, 10, 9};

    System.out.println(
        Arrays.toString(prices) + "output: " + new Integer(maxProfit(prices)));
  }


  public int maxProfit(int[] prices) {

    int i = 0;
    int buy = -1;
    int sell = -1;
    int profit = 0;

    while (i < prices.length - 1) {
      int delta = prices[i + 1] - prices[i];
      if (delta > 0) {
        profit += delta;
      }
      i++;
    }

    return profit;
  }
}