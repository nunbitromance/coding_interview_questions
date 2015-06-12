public int cuttingRod(int[] prices, int n) {
  int maxValue = 0;
  int[] opt = new int[n + 1];
  for (int i = 0; i <= n; i++) {
    int maxValue = Integer.MIN_VALUE;
    for (int j = 0; j < i; j++) {
      maxValue = Math.max(maxValue, prices[i] + opt[i-j-1]);
    }
    opt[i] = maxValue;
  }
  return opt[n];
}
