/*
Best Time to Buy and Sell Stock III
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

p = { 25, 24, 22, 11, 23, 13, 10, 25} => buy at 10 and sell at 25 => 15
p = { 25, 23, 22, 12, 11, 10, 25, 9} => buy at 10 and sell at 25 => 15
*/
public static int GetMaxProfit(int[] p, )
{
	int minPrice = p[0];
	int maxDiff = 0;
	
	for (int i = 1; i < p.Length; i++)
	{
		if (p[i] < minPrice)
		{
			minPrice = p[i];
		}
		int diff = p[i] - minPrice;
		if (diff > maxDiff)
		{
			maxDiff = diff;
		}
	}
	
	return maxDiff;	
}
