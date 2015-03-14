// find 3 numbers a, b, c such that a + b + c = s
public static void find3Sum(int[] a, int s)
{
	Dictionary<int, int> dic = new Dictionary<int, int>();
	
	for (int i=0; i < a.length; i++)
	{
		dic.insert(a[i], i);
	}
	
	int i = 0; 
	int j = a.length - 1;
	
	for (int i = 0; i < a.length - 1; i++)
	{
		for (int j = i + 1; j < a.length; j++)
		{
			int 2sum = a[i] + a[j];
			if (dic.containsKey(s - 2sum) && dic[s-2sum] != i && dic[s-2sum] != j)
			{
				print(a[i], a[j], dic[s-2sum]);
			}
		}
	}
}