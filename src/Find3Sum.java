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

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        
        // sort array
	Arrays.sort(num);
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	for (int i = 0; i < num.length - 2; i++) {
		if (num[i] > 0) {
		    break;
		}
		
		int j = i + 1;
		int k = num.length - 1;
		while (j < k) {
		    if (num[i] + num[j] > 0 && num[j] > 0) {
		        break;
		    }
		    int sum = num[i] + num[j] + num[k];
		    if (sum == 0) {
					List<Integer> each = new ArrayList<Integer>();
					each.add(num[i]);
					each.add(num[j]);
					each.add(num[k]);
					result.add(each);
		    }
		    
		    while (k < num.length - 1 && num[k] == num[k - 1]) {
			    k--;
		    }
		    
		    while (j < num.length - 2 && num[j] == num[j + 1]) {
		        j++;
		    }
		    
		    if (sum > 0) {
		        k--;
		    } else {
		        j++;
		    }
		}
		while (i + 1 < num.length - 3 && num[i] == num[i + 1]) {
		        i++;
		}
		i++;
	}
	return result;
    }
}
