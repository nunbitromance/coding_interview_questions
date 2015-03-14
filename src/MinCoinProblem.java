// Top-down approach
// sum: 11
// denoms: 1, 5, 7
// OPT(s) = Min(OPT(s-i) + 1) for all j's
public static int minCoins(int sum, int[] denoms)
{
	if (sum < 0)
    {
        throw new ArgumentException("sum is less than 0");
    }
    else if (denoms == null || denoms.length == 0)
    {
        throw new ArgumentException("denoms is null or size 0");
    }   

    Dictionary<int, int> memo = new Dictionary<int, int>();
	memo.insert(0, 0);
    return minCoins(sum, denoms, memo);
}

private static int minCoins(int sum, int[] denoms, Dictionary<int, int> memo)
{
    if (memo.containsKey(sum))
    {
        return memo.get(sum);
    }
       
    for (int i=1; i < minCoins.length; i++)
    {
        int min = int.Max;
        
        for (int j=0; j < denoms.length; j++)
        {
            if (j <= i)
            {
				int minCoinsSoFar = minCoins(i - denoms[j], denoms, memo);
				if (min < minCoinsSoFar)
				{
					min = minCoinsSoFar;
				}
            }
        }
        memo.add(i, minCoins[i]);
    }
    return minCoins[sum];
}

// Bottom-up approach
public static int minCoins(int sum, int[] denoms)
{
    if (sum < 0)
    {
        throw new ArgumentException("sum is less than 0");
    }
    else if (denoms == null || denoms.length == 0)
    {
        throw new ArgumentException("denoms is null or size 0");
    }   
    
    int[] minCoins = new int[sum + 1];
    minCoins[0] = 0;
    
    for (int i=1; i < minCoins.length; i++)
    {
        int min = int.Max;
        
        for (int j=0; j < denoms.length; j++)
        {
            if (j <= i && min < minCoins[i - denoms[j]])
            {
                min = minCoins[i - denoms[j]];
            }
        }
        minCoins[i] = min + 1;
    }
    
    return minCoins[sum];
}