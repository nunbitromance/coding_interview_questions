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
	
	if (k == 0) {
		if (cur.size() == k) {
			result.add(cur);
			return;
		}
	}

	for (int i = start; i <= arr.length && result.length - i + 1 >= k - start ; i++) {
		cur.add(arr[i]);
		getAllCombinations(arr, result, cur, n, k - 1, i + 1, end);
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
