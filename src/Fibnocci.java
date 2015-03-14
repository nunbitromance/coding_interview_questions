int[] fib(int n)
{
	int result = new int[n];
	result[0] = 0;
	result[1] = 1;
	
	for (int i = 2; i < n; i++)
	{
		result[i] = result[i-1] + result[i-2];
	}
	
	return result;
}

int fib(int n, int k)
{
	int result = new int[n];
	result[0] = 0;
	result[1] = 1;
	
	for (int i = 2; i < n; i++)
	{
		for (int j = 0; j < k; j++)
		{
			result[i] += result[i-j];
		}
	}
	
	return result[n-1];
}