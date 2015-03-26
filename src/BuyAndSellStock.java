/*
Best Time to Buy and Sell Stock Total Accepted: 44390 Total Submissions: 137184 My Submissions Question Solution 
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/
public int maxProfix(int[] prices) {
  int minIndex = 0;
  int maxDiff = 0;
  int curDiff = 0;
  for (int i = 0; i < prices.length; i++) {
    if (prices[i] < prices[minIndex]) {
      minIndex = prices[i];
    }
    curDiff = prices[i] - prices[minIndex];
    if (curDiff > maxDiff) {
      maxDiff = curDiff;
    }
  }
  return maxDiff;
}
