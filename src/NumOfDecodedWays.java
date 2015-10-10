/*
Decode WaysJun 25 '12
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/
// "12" -> "AB" or "L"
public class NumOfDecodings {

    public int numOfDecodings(String s) {
        int[] opt = new int[s.length()+1];
        opt[0] = 1;
        opt[1] = isValid(s.substring(0, 1)) ? 1 : 0;
        
        for (int i = 2; i <= s.length(); i++) {
            if (isValid(s.substring(i-1, i))) {
                opt[i] += opt[i-1];
            } 
            if (isValid(s.substring(i-2, i))) {
                opt[i] += opt[i-2];
            }
        }
        return opt[s.length()];
    }
    
    public boolean isValid(String s){
        if(s.charAt(0)=='0')
            return false;
        int value = Integer.parseInt(s);
        return value>=1&&value<=26;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "226";
        System.out.println(new NumOfDecodings().numOfDecodings(s));
    }

}
