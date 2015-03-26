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
