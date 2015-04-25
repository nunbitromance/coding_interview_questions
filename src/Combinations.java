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
public List<List<Integer>> getAllCombinations(int[] arr, int k) {
	
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> cur = new ArrayList<Integer>();
	getAllCombinations(arr, k, result, cur, 0);
}

private void getAllCombinations(int[] arr,  int k, int start, List<List<Integer>> result, List<Integer> cur) {
	
	if (start == k) {
		if (cur.size() == k) {
			result.add(cur);
		}
		return;
	}

	for (int i = start; i <= arr.length && result.length - i + 1 >= k - start ; i++) {
		cur.add(arr[i]);
		getAllCombinations(arr, k, start+1, result, cur);
		cur.remove(arr[i]);
	}
}


C(4, 2)
1, 2, 3, 4

1, 2
1, 3
1, 4

2, 3
2, 4

3, 4

4

public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
 
	if (n <= 0 || n < k)
		return result;
 
	ArrayList<Integer> item = new ArrayList<Integer>();
	dfs(n, k, 1, item, result); // because it need to begin from 1
 
	return result;
}
 
private void dfs(int n, int k, int start, ArrayList<Integer> item,
		ArrayList<ArrayList<Integer>> res) {
	if (item.size() == k) {
		res.add(new ArrayList<Integer>(item));
		return;
	}
 
	for (int i = start; i <= n; i++) {
		item.add(i);
		dfs(n, k, i + 1, item, res);
		item.remove(item.size() - 1);
	}
}
