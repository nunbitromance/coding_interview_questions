import java.util.ArrayList;
import java.util.List;

/*
  input: "abc"
  output: [abc, Abc, aBc, ABc, abC, AbC, aBC, ABC]
*/
public class PermutationsOfUpperAndLowerCases {

    public List<String> getAllCases(String s) {
        List<String> result = new ArrayList<String>();
        char[] cArr = s.toCharArray();
        for (int i = 0; i < Math.pow(2, s.length()); i++) {
            char[] temp = new char[cArr.length];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = isBitSet(i, j) ? Character.toUpperCase(cArr[j]) : Character.toLowerCase(cArr[j]);
            }
            result.add(new String(temp));
        }
        return result;
    }
    
    private boolean isBitSet(int i, int j) {
        return ((i >> j) & 1) == 1;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> result = new PermutationsOfUpperAndLowerCases().getAllCases("abc");
        System.out.println("result=" + result.toString());
    }

}
