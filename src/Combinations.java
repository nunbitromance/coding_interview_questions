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
public List<List<Integer>> getAllCombinations(int[] arr, int n, int k) {
	
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> cur = new ArrayList<Integer>();
	getAllCombinations(arr, result, cur, n, k, 0, n - 1);
}

private void getAllCombinations(int[] arr, List<List<Integer>> result, List<Integer> cur, int n, int k, int start, int end) {
	
	if (k == 0) {
		result.add(cur);
		return;
	}

	for (int i = start; i <= end; i++) {
		cur.add(arr[i]);
		getAllCombinations(arr, result, cur, n, k - 1, i + 1, end);
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
