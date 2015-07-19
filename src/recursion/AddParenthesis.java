public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        helper(0, 0, n, "", result);
        return result;
    }
    
    private void helper(int l, int r, int n, String s, List<String> result) {
        if (l == n && r == n) {
            result.add(s);
            return;
        }
        
        if (l < n) {
            helper(l+1, r, n, s + "(", result);
        }
        
        if (l > r) {
            helper(l, r+1, n, s + ")", result);
        }
    }
}
