/*
Given a string S, find the longest palindromic substring in S.
s = "abac" => "aba"

Define P[ i, j ] ? true iff the substring Si � Sj is a palindrome, otherwise false.
Therefore,

P[ i, j ] ? ( P[ i+1, j-1 ] and Si = Sj )
The base cases are:

P[ i, i ] ? true
P[ i, i+1 ] ? ( Si = Si+1 )
*/

public class LongestPalindromicSubstring {

    public String longestPalindromicSubstring(String s) {
        // validation
        
        boolean[][] opt = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            opt[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            opt[i][i+1] = (s.charAt(i) == s.charAt(i+1))? true : false;
        }
        String longestPalindromicSubstring = "";
        int maxLength = 0;
        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; i < s.length() - l + 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && opt[i+1][j-1]) {
                    opt[i][j] =  true;
                    if (l > maxLength) {
                        maxLength = l;
                        longestPalindromicSubstring = s.substring(i, j + 1);
                    }
                } else {
                    opt[i][j] = false;
                }
            }
        }
        return longestPalindromicSubstring;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "HelloWorld";
        System.out.println(new LongestPalindromicSubstring().longestPalindromicSubstring(s));
    }

}
