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
