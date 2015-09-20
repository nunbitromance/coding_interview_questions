/*
Minimum Window SubstringApr 15 '12
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/
/*  
  * Two pointers: one for window_left and one for window_right  
  * As moving to the right, we know which char is in T,  
  * store the index into an array so that left point can directly  
  * jump to next spot.  
  */  
 public String minWindow(String S, String T) {  
   int ss = S.length(), tt = T.length();  
   // build up hashmap for T and also keep track of occurrence  
   HashMap<Character, Integer> needFind = new HashMap<Character, Integer>();  
   HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();  
   for (int i=0; i<tt; ++i) {  
     hasFound.put(T.charAt(i), 0);  
     if (needFind.containsKey(T.charAt(i))) {  
       needFind.put(T.charAt(i), needFind.get(T.charAt(i))+1);  
     } else {  
       needFind.put(T.charAt(i), 1);  
     }  
   }  

   // keep found T-letters in an array to avoid revisit non-T-letters when forwarding left
   ArrayList<Integer> nexts = new ArrayList<Integer>();  
   // window = S[nexts.get(left), S[right]]
   int right = 0, found = 0, left = 0;  

   // sliding window as needed  
   String window = "";  
   int winSize = Integer.MAX_VALUE;  
   while (right < S.length()) {  
     char c = S.charAt(right);  
     if (!needFind.containsKey(c)) { // not a match  
       ++right;  
       continue;  
     }  
   
     nexts.add(right);  
     ++right;  
     hasFound.put(c, hasFound.get(c)+1);  
     if (hasFound.get(c) <= needFind.get(c)) ++found;  
   
     if (found >= tt) { // got a window  
       // forward left?  
       char ll = S.charAt(nexts.get(left));  
       while (hasFound.get(ll) > needFind.get(ll)) {  
         hasFound.put(ll, hasFound.get(ll)-1);  
         ++left;  
         ll = S.charAt(nexts.get(left));  
       }  
       // smaller window?  
       if (right - nexts.get(left) < winSize) {  
         winSize = right - nexts.get(left);  
         window = S.substring(nexts.get(left), right);  
       }  
     }  
   }  
   return window;  
 }  
	
	return s.Substring(minWindowStart, minWindowEnd - minWindowStart + 1);
}
