public static int getNumOfIntegersWith5(int n)
{
	if (n < 0)
	{
		throw new ArgumentException("n is less than 0");
	}
	
	int count = 0;
	for (int i = 1; i * 5 < n; i+=2)
	{
		count++;
	}
	
	return count;
}