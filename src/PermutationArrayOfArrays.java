/*
Permutations of an Array of Arrays
Given a list of array, return a list of arrays, each array is a combination of one element in each given array.
Let me give you an example to help you understand the question Suppose the input is [[1, 2, 3], [4], [5, 6]], the output should be [[1, 4, 5], [1, 4, 6], [2, 4, 5], [2, 4, 6], [3, 4, 5], [3, 4, 6]].

This question permutations of an array of arrays has been asked not only by Uber recently, 
but also a lot of other companies like Google and Facebook. The reason I like it is that candidates 
really need a solid computer science foundation in order to solve it. Also, it’s not that easy to have bug-free code solution.
*/

public List<List<Integer>> permute(int[][] nums, int i) {
  List<List<Integer>> result = null;
  if (i == nums.length) {
    result = new ArrayList<List<Integer>();
    result.add(new ArrayList<Integer>());
    return result;
  }
  
  List<List<Integer>> rest = permute(nums, i+1);
  List<List<Integer>> result = new ArrayList<>();
  for (List<Integer> r : rest) {
    for (int m : nums[i]) {
      List<Integer> r2 = new ArrayList<Integer>(r);
      r2.add(m);
      result.add(r2);
    }
  }
  return result;
}
