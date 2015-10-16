/*
The longest common substring of the strings "ABABC", "BABCA" and "ABCBA" is string "ABC" of length 3. Other common substrings are "AB", "BC" and "BA".
*/
package practice;

public class LongestCommonSubstring {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("lcs = " + new LongestCommonSubstring().lcs("ABABC", "DABCA"));
    }

    public String lcs(String s1, String s2) {
        // validation
        
        int lcs = 0;
        int start = -1;
        int end = -1;
        int[][] opt = new int[s1.length()][s2.length()];
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                opt[i][0] = 1;
                lcs = 1;
                start = i;
                end = 0;
            }
        }
        
        for (int j = 0; j < s2.length(); j++) {
            if (s1.charAt(0) == s2.charAt(j)) {
                opt[0][j] = 1;
                lcs = 1;
                start = 0;
                end = j;
            }
        }
        
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    opt[i][j] = opt[i-1][j-1] + 1;
                } else {
                    opt[i][j] = 0;
                }
                
                if (opt[i][j] > lcs) {
                    lcs = opt[i][j];
                    start = i - lcs + 1;
                    end = i;
                }
            }
        }
        System.out.println(lcs);
        return s1.substring(start, end + 1);
    }
    
}
