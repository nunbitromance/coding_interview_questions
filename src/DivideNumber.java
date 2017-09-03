divide number and return result in a string
This is a google interview question: 

Divide number and return result in form of a string. e.g 100/3 result should be 33.(3) Here 3 is in brackets because it 
gets repeated continuously and 5/10 should be 0.5.

Here is my attempt, the key is to doing module and division, also figure out how many 0s are there after decimal point. 




public static String divideToString(int num1, int num2){
     int q = num1/num2;
     int r = num1%num2;
     boolean flag = false;
     Set<Integer> seen = new HashSet<Integer>();
     StringBuilder sb = new StringBuilder();
     sb.append(q);
     
     StringBuilder sb2 = new StringBuild();
     Set<Integer> seen = new HashSet<>();
     boolean repeating = false;
     
     while ( r > 0) {
          num1 = r * 10;
          q = num1 / num2;
          r = num1 % num2;
          if (seen.contains(q)) {
               repeating = true;
               sb2.append(q);
               break;
          } else {
               sb2.append(q);
               seen.add(q);
          }
     }
     if (repeating) {
          sb.append("(");
          sb.append(sb2.toString());
          sb.append(")");
     } else {
          sb.append(sb2.toString());    
     }
     return sb.toString();
}
