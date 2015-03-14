
// Returns optimal knapsack maximum value
public static int getKnapsack(int[] weights, int[] values, int maxWeight)
{
	if (maxWeight < 0)
	{
		throw new ArgumentException("maxWeight is less than 0");
	}
	else if (weights == null)
	{
		throw new ArgumentNullException("weights");
	}
	else if (values == null)
	{
		throw new ArgumentNullException("values");
	}
	else if (weights.length != values.length)
	{
		throw new ArgumentException("weights and values have different lengths");
	}
	
	// row: item index, col: weights
	int[][] knapSack = new int[weights.length+1][maxWeight + 1];
	
	for (int i = 0; i < maxWeight + 1; i++)
	{
		knapSack[0][i] = 0;
	}
	for (int j = 0; j < weights.length; j++)
	{
		knapSack[j][0] = 0;
	}
	
	for (int i = 1; i <= weights.length; i++)
	{
		for (int j = 1; j <= maxWeight; j++)
		{
			//knapSack[i][j] = Math.Max(knapSack[i-1][j], j >= weights[i] ? knapSack[i-1][j-weights[i]] + values[i] : knapSack[i-1][j]);
			knapSack[i][j] = j >= weight[i] ? Math.Max(knapSack[i-1][j-weights[i]] + values[i] : knapSack[i-1][j]) : knapSack[i-1][j];
		}
	}
	
	return knapSack[weights.length - 1, maxWeights];
}

Dictionary<Tuple<int,int>, int> dic = new Dictionary<Tuple<int, int>, int>();

// Returns optimal knapsack maximum value
public static int getKnapsack(int[] weights, int[] values, int maxWeight)
{
	if (maxWeight < 0)
	{
		throw new ArgumentException("maxWeight is less than 0");
	}
	else if (weights == null)
	{
		throw new ArgumentNullException("weights");
	}
	else if (values == null)
	{
		throw new ArgumentNullException("values");
	}
	else if (weights.length != values.length)
	{
		throw new ArgumentException("weights and values have different lengths");
	}
	
	// row: item index, col: weights
	int[][] knapSack = new int[weights.length+1][maxWeight + 1];
	
	for (int i = 0; i < maxWeight + 1; i++)
	{
		knapSack[0][i] = 0;
	}
	for (int j = 0; j < weights.length; j++)
	{
		knapSack[j][0] = 0;
	}
	
	for (int i = 1; i <= weights.length; i++)
	{
		for (int j = 1; j <= maxWeight; j++)
		{
			//knapSack[i][j] = Math.Max(knapSack[i-1][j], j >= weights[i] ? knapSack[i-1][j-weights[i]] + values[i] : knapSack[i-1][j]);
			knapSack[i][j] = j >= weight[i] ? Math.Max(knapSack[i-1][j-weights[i]] + values[i] : knapSack[i-1][j]) : knapSack[i-1][j];
		}
	}
	
	return knapSack[weights.length - 1, maxWeights];
}