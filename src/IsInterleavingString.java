public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
                // check special case
        if(s1.length() + s2.length() != s3.length()) return false;

        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        // an array for DP
        boolean[][] map = new boolean[l1+1][l2+1];
        map[0][0] = true;
        
        // init first line
        for(int i = 0; i < l1; i++) {
            if(s1.charAt(i) == s3.charAt(i)){
                map[i+1][0] = true;
            } else {
                // just break
                break;
            }
        }
        
        // init first row
        for(int i = 0; i < l2; i++) {
            if(s2.charAt(i) == s3.charAt(i)){
                map[0][i+1] = true;
            } else {
                break;
            }
        }
        // start DP
        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                // take care of this long statement
                map[i][j] = (map[i-1][j] && (s1.charAt(i-1) == s3.charAt(j+i-1)))
                         || (map[i][j-1] && (s2.charAt(j-1) == s3.charAt(j+i-1)));
            }
        }
        
        return map[l1][l2];
    }
}
