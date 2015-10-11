public class LongestCommonSubsequence {

    public int lcs(String s1, String s2) {
        int[][] opt = new int[s1.length() + 1][s2.length() + 1];
        opt[0][0] = 0;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    opt[i][j] = 0;
                }
                else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    opt[i][j] = opt[i-1][j-1] + 1;
                } else {
                    opt[i][j] = Math.max(opt[i-1][j], opt[i][j-1]);
                }
            }
        }
        
        for (int i = 0; i < opt.length; i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
        
        return opt[s1.length()][s2.length()];
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println(new LongestCommonSubsequence().lcs(s1, s2));
        // Result: ADH
    }

}
