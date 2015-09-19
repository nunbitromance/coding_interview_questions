/** Simplified pig-latin program:
    1) take first consonant and move to end, add "ay"
    2) if starts with vowel, add "hay" to end
*/

import java.util.Scanner;

public class pigLatin {
   public static void main(String[] args) {
   
      Scanner kb = new Scanner(System.in);
      String word, pig;
      char first;
      
      System.out.print("enter word: ");
      word = kb.next();
      //NOT: word.toLowerCase();
      word = word.toLowerCase();
      System.out.println(word);
      
      first = word.charAt(0);
      if (first == 'a' ||  first == 'e' || first == 'i' || 
         first == 'o' || first == 'u')  // vowel
         pig = word + "hay";      
      else
         pig = word.substring(1) + word.charAt(0) + "ay";
      
      System.out.println("pig-latin version: " + pig);
   }
}
