/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> memo = new HashMap<>();
        return helper(input, memo);
    }
    
    public List<Integer> helper(String input, Map<String, List<Integer>> memo) {
        if (memo.containsKey(input)) {
            return memo.get(input);
        }
        List<Integer> result = new ArrayList<Integer>();
        if (input.length() == 1) {
            result.add(Integer.parseInt(input));
        } else {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                    List<Integer> left = diffWaysToCompute(input.substring(0, i));
                    if (!memo.containsKey(input.substring(0, i))) {
                        memo.put(input.substring(0, i), left);
                    }
                    
                    List<Integer> right = diffWaysToCompute(input.substring(i+1));
                    if (!memo.containsKey(input.substring(i+1))) {
                        memo.put(input.substring(i+1), right);
                    }
                    
                    for (Integer l : left) {
                        for (Integer r : right) {
                            if (input.charAt(i) == '+') {
                                result.add(l + r);
                            } else if (input.charAt(i) == '-') {
                                result.add(l - r);
                            } else {
                                result.add(l * r);
                            }
                        }
                    }
                }
            }
        }
        
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        
        if (!memo.containsKey(input)) {
            memo.put(input, result);
        }
        
        return result;
    }
}
