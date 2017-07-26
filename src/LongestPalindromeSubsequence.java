/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 * Given a sequence, find the length of the longest palindromic subsequence in it. 
 * For example, if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce 
 * in it. “BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.
 */
package practice;

public class LongestPalindromicSubsequence {

    public int lps(String s) {
        // validation
        int[][] opt = new int[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            opt[i][0] = 1;
            opt[0][i] = 1;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            opt[i][i+1] = s.charAt(i) == s.charAt(i+1) ? 2 : 1;
        }
        
        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; i < s.length() - l + 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    opt[i][j] = opt[i+1][j-1] + 2;
                } else {
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j-1]);
                }
            }
        }
        
        return opt[0][s.length() - 1];
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "GEEKSFORGEEKS";
        System.out.println(new LongestPalindromicSubsequence().lps(s));
    }

}
