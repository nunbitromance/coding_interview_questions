/*Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
For example, if length of the rod is 8 and the values of different pieces are given as following, 
then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)


length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20
And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20
*/
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
