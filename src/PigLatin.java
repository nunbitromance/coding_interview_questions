/** Simplified pig-latin program:
    1) take first consonant and move to end, add "ay"
    2) if starts with vowel, add "hay" to end
*/


public class PigLatin {

    public String encode(String kb) {
        String word, pig;
        char first;

        word = kb;
        //NOT: word.toLowerCase();
        word = word.toLowerCase();    
        first = word.charAt(0);
        if (first == 'a' ||  first == 'e' || first == 'i' || 
           first == 'o' || first == 'u')  // vowel
           pig = word + "hay";      
        else
           pig = word.substring(1) + word.charAt(0) + "ay";
        return pig;
        
    }
    
    public String decode(String pig) {
        if (pig.endsWith("hay")) {
            return pig.substring(0, pig.length() - 3);
        } else if (pig.endsWith("ay")) {
            StringBuilder sb = new StringBuilder();
            sb.append(pig.charAt(pig.length()-3));
            sb.append(pig.substring(0, pig.length() - 3));
            return sb.toString();
        }
        return null;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        String word = "cabe";
        System.out.println("normal version: " + word);
        String pig = new PigLatin().encode(word);
        System.out.println("pig-latin version: " + pig);
        String word2 = new PigLatin().decode(pig);
        System.out.println("decoded version: " + word2);
    }

}
