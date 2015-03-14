// weights: w1 w2 w3 ... wn
// values:  v1 v2 v3 ... vn
// Returns dictionary of <item index, weight> for optimal knapsack
public Dictionary<int, int> getKnapSack(int[] weights, int[] values, int maxWeight)
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
	
	SortedDictionary<int, int> dic = new SortedDictionary<int, int>();
	for (int i = 0; i < weights.length)
	{
		dic.insert(weights[i]/values[i], i);
	}
	
	Dictionary<int, int> items = new Dictionary<int, int>();
	foreach (int key in dic.Keys)
	{
		int amount = maxWeight - dic[key] >= 0 ? dic[key] : maxWeight;
		items.add(dic.Value, amount);
		
		maxWeight -= amount;
		if (maxWeight <= 0)
		{
			break;
		}
	}
	
	return items;
}

