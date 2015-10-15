package practice;

public class SubstringSearch {

    public int substring(String s, String t) {
        // validation
        if (s.equals(t)) {
            return 0;
        }
        
        for (int i = 0; i < s.length() - t.length() + 1; i++) {
            int j = 0;
            for (;j<t.length(); j++) {
                if (s.charAt(i+j) != t.charAt(j)) {
                    break;
                }
            }
            if (j == t.length()) {
                return i;
            }
        }
        return -1;
    }
    
    public long substringRabinKarp(String s, String t) {
        // validation
        long hashS = hashCode(s, 0, t.length());
        long hashT = hashCode(t, 0, t.length());
        
        if (hashS == hashT) {
            return 0;
        }
        long x = 1;
        for (int i = 0; i < t.length(); i++) {
            x = (x << 5) - x;
        }
        for (int i = 1; i < s.length() - t.length() + 1; i++) {
            hashS = (hashS << 5) - hashS - (x * s.charAt(i - 1)) + s.charAt(i + t.length() - 1);
            if (hashS == hashT) {
                return i;
            }
        }
        return -1;
    }
    
    private long hashCode(String s, int begin, int length) {
        int result = 0;
        for (int i = begin; i < begin + length; i++) {
            result = (result << 5) - result + s.charAt(i);
        }
        return result;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "ABCDEFGHIJKLMN";
        String t = "DEF";
        System.out.println("regular search result: " + new SubstringSearch().substring(s, t));
        System.out.println("rabin karp result: " + new SubstringSearch().substringRabinKarp(s, t));
    }

}
