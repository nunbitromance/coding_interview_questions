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
public static void printAllCombinationsOfSizeK(int[] arr, int start, int level, int k, List<Integer> result) {
	if (level >= k) {
		if (result.size() == k) {
			System.out.println("arr=" + result);
		}
		return;
	}
	
	for (int i = start; i < arr.length; i++) {
		result.add(arr[i]);
		printAllCombinationsOfSizeK(arr, i+1, level+1, k, result);
		result.remove(result.size() - 1);
	}
}
