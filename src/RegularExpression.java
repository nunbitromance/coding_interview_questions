/*
Implement regular expression matching with support for ‘.’ and ‘*’.

‘.’ Matches any single character.
‘*’ Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch(“aa”,”a”) ℃ false
isMatch(“aa”,”aa”) ℃ true
isMatch(“aaa”,”aa”) ℃ false
isMatch(“aa”, “a*”) ℃ true
isMatch(“aa”, “.*”) ℃ true
isMatch(“ab”, “.*”) ℃ true
isMatch(“aab”, “c*a*b”) ℃ true
*/

public class RegularExpression {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (p.length() == 1) {
            if (s.length() == 0) {
                return false;
            }
            return (p.charAt(0) == '.' && s.length() == 1) || p.equals(s);
        } else if (p.charAt(1) != '*') {
            if (s.length() == 0) {
                return false;
            }
            return (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && isMatch(s.substring(1), p.substring(1));
        } else {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            
            int i = 0;
            while (i < s.length() && (s.charAt(i) == p.charAt(0) || (p.charAt(0) == '.'))) {
                if (isMatch(s.substring(i+1), p.substring(2))) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
    
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }
        boolean[][] state = new boolean[s.length() + 1][p.length() + 1];
        state[0][0] = true;
        // no need to initialize state[i][0] as false
        // initialize state[0][j]
        for (int j = 1; j < state[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                if (state[0][j - 1] || (j > 1 && state[0][j - 2])) {
                    state[0][j] = true;
                }
            } 
        }
        for (int i = 1; i < state.length; i++) {
            for (int j = 1; j < state[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    state[i][j] = state[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        state[i][j] = state[i][j - 2];
                    } else {
                        state[i][j] = state[i - 1][j] || state[i][j - 1] || state[i][j - 2];
                    }
                }
            }
        }
        return state[s.length()][p.length()];
    }
    
    

    public bool isMatch(String s, String p) {
        // validation

        if (p.charAt(1) != '*') {//without *
            if(!(p.charAt(0) == s.charAt(0) || (p.charAt(0) == '.'))) return false;
            return isMatch(s.substring(1), p.substring(1));
        } else { //next: with a *
            if(isMatch(s, p.substring(2))) {
                return true;    //try the length of 0
            }
            int start = 0;
            while (p.charAt(0) == s.charAt(start) || (p.charAt(0) == '.')) {       //try all possible length
                if (isMatch(s.substring(start++), p.charAt(2))) {
                    return true;
                }
                start++;
            }
        }
    }
    
    private boolean matchFirst(String s, String p){
        return (p.charAt(0) == s.charAt(0) || (p.charAt(0) == '.'));
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new RegularExpression().isMatch("aa","a")); //false
        System.out.println(new RegularExpression().isMatch("aa","aa")); // true
        System.out.println(new RegularExpression().isMatch("aaa","aa")); // false
        System.out.println(new RegularExpression().isMatch("aa", "a*")); //true
        System.out.println(new RegularExpression().isMatch("aa", ".*")); //true
        System.out.println(new RegularExpression().isMatch("ab", ".*")); // true
        System.out.println(new RegularExpression().isMatch("aab", "c*a*b")); //true
    }

}
