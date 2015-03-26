// P = n! / (n-k)!
/* 
Print all permutations of a string
*/
public static void List<string> getPermutations(string s)
{
    if (string.IsNullOrEmpty(s))
    {
        List<string> list = new List<string>();
        list.add("");
        return list;
    }
    
    char c = s.charAt(0);
    List<string> remainder = getPermutations(s.substring(1));
    List<string> result = new List<string>();
    foreach (string r in remainer)
    {
        for (int i = 0; i <= r.length; i++)
        {
            result.add(insertChar(r, c, i));
        }
    }
    
    return result;
}

private static string insertChar(string r, char c, int i)
{
    return r.substring(0, i) + c + r.substring(i);
}

/*
Print all permutations of an array.
*/
public static void PrintAllPermutations(int[] a, int l)
{
	if (a.Length == l)
	{
		Print(a);
	}
	
	for (int i = l; i < a.Length; i++)
	{
		Swap(a, l, i);
		PrintAllPermutations(a, l+1);
		Swap(a, i, l);
	}
}

private static void Swap(int[] a, int i, int j)
{
	int t = a[i];
	a[i] = a[j];
	a[j] = t;
}

/*
Pritn k-th permutation sequence of an array
*/
public static void PrintAllPermutations(int[] a, int l, ref int k)
{
	if (a.Length == l)
	{
		k--;
		if (k == 0)
		{
			Print(a);
		}
	}
	
	for (int i = l; i < a.Length; i++)
	{
		Swap(a, l, i);
		PrintAllPermutations(a, l+1);
		Swap(a, i, l);
	}
}

private static void Swap(int[] a, int i, int j)
{
	int t = a[i];
	a[i] = a[j];
	a[j] = t;
}

public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(num, 0, result);
        return result;
    }
    
    private void permute(int[] num, int i, List<List<Integer>> result) {
        if (i == num.length) {
            List<Integer> r = new ArrayList<Integer>();
            for (int k = 0; k < num.length; k++) {
                r.add(num[k]);
            }
            result.add(r);
            return;
        }
        
        for (int j = i; j < num.length; j++) {
            swap(num, i, j);
            permute(num, i + 1, result);
            swap(num, j, i);
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
