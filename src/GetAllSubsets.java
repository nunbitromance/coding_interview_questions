// Get all subsets of string s.
// e.g. "ABC" -> {"ABC", "AB", "BC", "AC", "A", "B", "C", ""}
public static List<string> GetAllSubsets(string s)
{
	if (s.length == 0)
	{
		List<string> result = new List<string>();
		result.Add("");
		return result;
	}
	char first = s.charAt(0);
	List<string> rest = GetAllSubsets(s.Substring(0));
	List<string> result = new List<string>();
	foreach (string s in rest)
	{
		result.Add(s);
		result.Add(first + s);
	}
	return result;
}

public static void GetAllSubsets(List<int> m,  int index, List<int> a, List<List<int>> result)
{
	if (index == m.Length)
	{
		result.Add(a);
		return;
	}
	
	int i = m[index];
	
	GetAllSubsets(m, index + 1, a.Clone(), result);
	a.Add(i);
	GetAllSubsets(m, index + 1, a, result);
}

// C = n! / r!*(n-r)!

/*
Subsets IIJun 25 '12
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
{}, {1}, {2}, {2}, {2, 2}, {1}, {1,2}, {1,2}, {1,2,2}
*/
public static List<List<int>> GetAllSubsetsNoDupicates(int[] s, int index)
{
	if (index == s.Length)
	{
		List<List<int>> result = new List<List<int>>();
		result.Add(new List<int>());
		return result;
	}
	
	int first = s[index];
	List<List<int>> rest = GetAllSubsets(s, index + 1);
	List<List<int>> result = new List<List<int>>();
	foreach (List<int> r in rest)
	{
		List<int> c = r.Clone();
		c.Add(first);
		
		result.Add(r);
		result.Add(c);
	}
	
	return result;
}
