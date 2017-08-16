/*
Combination Sum

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. 
The same repeated number may be chosen from C unlimited number of times.
For example, given candidate set 2,3,6,7 and target 7, a solution set is:
[7] 
[2, 2, 3] 
*/

public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {  
   ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();  
   Arrays.sort(candidates);  
   addUp(candidates, 0, target, new ArrayList<Integer>(), results);  
   return results;  
 }  
   
 private void addUp(int[] candidates, int start, int target, ArrayList<Integer> path,  
     ArrayList<ArrayList<Integer>> results) {  
   if (start < 0 || target < 0) return;  
   
   if (0 == target) {  
     ArrayList<Integer> res = new ArrayList<Integer>(path);  
     results.add(res);  
   } else {  
     for (int i=start; i<candidates.length && candidates[i] <= target; ++i) {  
       // if (candidates[i] > target) continue; // if we don't sort the data at the beginning, we skip large numbers here  
       path.add(candidates[i]);  
       addUp(candidates, i, target - candidates[i], path, results);  
       path.remove(path.size() - 1);  
     }  
   }  
 }  
 
 /*
 Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, a solution set is:
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
 */
 
  public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {  
   ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();  
   Arrays.sort(candidates);  
   addUp(candidates, 0, target, new ArrayList<Integer>(), results);  
   return results;  
 }  
   
 private void addUp(int[] candidates, int start, int target, ArrayList<Integer> path,  
     ArrayList<ArrayList<Integer>> results) {  
   if (start < 0 || target < 0) return;  
   
   if (0 == target) {  
     ArrayList<Integer> res = new ArrayList<Integer>(path);  
     results.add(res);  
   } else {  
     for (int i=start; i<candidates.length && candidates[i] <= target; ++i) {  
       if (i>start && candidates[i] == candidates[i-1]) continue; // skip duplicates  
       path.add(candidates[i]);  
       addUp(candidates, i+1, target - candidates[i], path, results);  
       path.remove(path.size() - 1);  
     }  
   }  
 }  

Think about the recurrence relation first. How does the # of combinations of the target related to the # of combinations of numbers that are smaller than the target?

So we know that target is the sum of numbers in the array. Imagine we only need one more number to reach target, this number can be any one in the array, right? So the # of combinations of target, comb[target] = sum(comb[target - nums[i]]), where 0 <= i < nums.length, and target >= nums[i].

In the example given, we can actually find the # of combinations of 4 with the # of combinations of 3(4 - 1), 2(4- 2) and 1(4 - 3). As a result, comb[4] = comb[4-1] + comb[4-2] + comb[4-3] = comb[3] + comb[2] + comb[1].

Then think about the base case. Since if the target is 0, there is only one way to get zero, which is using 0, we can set comb[0] = 1.

EDIT: The problem says that target is a positive integer that makes me feel it's unclear to put it in the above way. Since target == 0 only happens when in the previous call, target = nums[i], we know that this is the only combination in this case, so we return 1.

Now we can come up with at least a recursive solution.

public int combinationSum4(int[] nums, int target) {
    if (target == 0) {
        return 1;
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
        if (target >= nums[i]) {
            res += combinationSum4(nums, target - nums[i]);
        }
    }
    return res;
}
Now for a DP solution, we just need to figure out a way to store the intermediate results, to avoid the same combination sum being calculated many times. We can use an array to save those results, and check if there is already a result before calculation. We can fill the array with -1 to indicate that the result hasn't been calculated yet. 0 is not a good choice because it means there is no combination sum for the target.

private int[] dp;

public int combinationSum4(int[] nums, int target) {
    dp = new int[target + 1];
    Arrays.fill(dp, -1);
    dp[0] = 1;
    return helper(nums, target);
}

private int helper(int[] nums, int target) {
    if (dp[target] != -1) {
        return dp[target];
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
        if (target >= nums[i]) {
            res += helper(nums, target - nums[i]);
        }
    }
    dp[target] = res;
    return res;
}
EDIT: The above solution is top-down. How about a bottom-up one?

public int combinationSum4(int[] nums, int target) {
    int[] comb = new int[target + 1];
    comb[0] = 1;
    for (int i = 1; i < comb.length; i++) {
        for (int j = 0; j < nums.length; j++) {
            if (i - nums[j] >= 0) {
                comb[i] += comb[i - nums[j]];
            }
        }
    }
    return comb[target];
}
More...

