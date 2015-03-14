/*
	Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	
	For example,
	If n = 4 and k = 2, a solution is:
	
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
*/
public static List<List<int>> Combinations(int[] m, int n, int k)
{
	List<List<int>> result = new List<List<int>>();

	if (k == 1)
	{
		for (int i = 0; i < m.Length; i++)
		{
			result.Add(new List<int>(){ m[i] });
		}
		return result;
	}
	
	rest= Combinations(m, k-1);
	
	foreach (List<int> r in rest)
	{
		for (int i = 0; i < m.Length; i++)
		{
			r.Add(m[i]);
			result.Add(r);
		}
	}
	
	return result;
}