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
