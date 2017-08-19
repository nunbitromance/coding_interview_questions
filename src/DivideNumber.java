divide number and return result in a string
This is a google interview question: 

Divide number and return result in form of a string. e.g 100/3 result should be 33.(3) Here 3 is in brackets because it gets repeated continuously and 5/10 should be 0.5.

Here is my attempt, the key is to doing module and division, also figure out how many 0s are there after decimal point. 




public static String divideToString(int num1, int num2){
     int d = num1/num2;
     int m = num1%num2;
     boolean flag = false;
     Set<Integer> seen = new HashSet<Integer>();
     StringBuilder sb = new StringBuilder();
     sb.append(d);
     while(m!=0){
      if(!flag){
          sb.append(".(");
          flag = true;
      }  
      
      num1 = m*10;
      d = num1/num2;
      m = num1%num2;
        
      if(seen.contains(num1)){
       sb.append(")");
       break;
      }else{
       sb.append(d);   
       seen.add(num1);
      }
      }
     
     return sb.toString();
}
